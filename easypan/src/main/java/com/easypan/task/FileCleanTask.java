package com.easypan.task;

import com.easypan.entity.enums.*;
import com.easypan.entity.po.*;
import com.easypan.entity.query.*;
import com.easypan.service.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

import javax.annotation.*;
import java.util.*;
import java.util.stream.*;

@Component
public class FileCleanTask {

    @Resource
    private FileInfoService fileInfoService;

    @Scheduled(fixedDelay = 1000 * 60 * 3)
    public void execute() {
        FileInfoQuery fileInfoQuery = new FileInfoQuery();
        fileInfoQuery.setDelFlag(FileDelFlagEnums.RECYCLE.getFlag());
        fileInfoQuery.setQueryExpire(true);
        List<FileInfo> fileInfoList = fileInfoService.findListByParam(fileInfoQuery);
        Map<String, List<FileInfo>> fileInfoMap = fileInfoList.stream().collect(Collectors.groupingBy(FileInfo::getUserId));
        for (Map.Entry<String, List<FileInfo>> entry : fileInfoMap.entrySet()) {
            List<String> fileIds = entry.getValue().stream().map(p -> p.getFileId()).collect(Collectors.toList());
            fileInfoService.delFileBatch(entry.getKey(), String.join(",", fileIds), false);
        }
    }
}
