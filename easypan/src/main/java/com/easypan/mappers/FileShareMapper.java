package com.easypan.mappers;

import org.apache.ibatis.annotations.*;

import org.apache.ibatis.annotations.Mapper;

/**
 * 分享信息 数据库操作接口
 */
@Mapper
public interface FileShareMapper<T, P> extends BaseMapper<T, P> {

    /**
     * 根据ShareId更新
     */
    Integer updateByShareId(@Param("bean") T t, @Param("shareId") String shareId);


    /**
     * 根据ShareId删除
     */
    Integer deleteByShareId(@Param("shareId") String shareId);


    /**
     * 根据ShareId获取对象
     */
    T selectByShareId(@Param("shareId") String shareId);

    Integer deleteFileShareBatch(@Param("shareIdArray") String[] shareIdArray, @Param("userId") String userId);

    void updateShareShowCount(@Param("shareId") String shareId);
}
