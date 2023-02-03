package com.dev.tool.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author puye(0303)
 */
@Slf4j
public class VoUtil {
    /**
     * eList -> vList
     *
     * @param eList      源数据
     * @param vClass     目标类型
     * @param removeNull 是否移除null值
     * @param <E>        Entity
     * @param <V>        Vo
     * @return List
     */
    public static <E, V> List<V> e2vList(List<E> eList,
                                         Class<V> vClass,
                                         Boolean removeNull) {
        List<V> vList = new ArrayList<>();
        if (null == eList || null == vClass) {
            return vList;
        }

        AtomicReference<Boolean> hasErr = new AtomicReference<>(false);
        eList.forEach(e -> {
            try {
                if (Boolean.TRUE.equals(hasErr.get())) {
                    return;
                }
                V v = vClass.getDeclaredConstructor().newInstance();
                if (null != removeNull && removeNull) {
                    BeanUtils.copyProperties(e, v, getNullPropertyNames(e));
                } else {
                    BeanUtils.copyProperties(e, v);
                }
                vList.add(v);
            } catch (Exception ex) {
                log.error("Entity[{}] to Vo[{}] error: {}", e.getClass().getName(), vClass.getName(), ex.getMessage());
                log.error(ex.getMessage(), ex);
                hasErr.set(true);
            }
        });

        if (Boolean.TRUE.equals(hasErr.get())) {
            return new ArrayList<>();
        }
        return vList;
    }


    /**
     * 获取实体属性为null的集合
     *
     * @param source 数据实体
     * @return String[]
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null || "".equals(srcValue)) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }


    /**
     * 实体镜像
     *
     * @param source     源数据
     * @param target     目标数据
     * @param removeNull 是否移除null值
     */
    public static void s2t(Object source, Object target, Boolean removeNull) {
        if (null != removeNull && removeNull) {
            BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
        } else {
            BeanUtils.copyProperties(source, target);
        }
    }


    /**
     * entity -> vo
     *
     * @param source     源数据
     * @param vClass     目标类型
     * @param removeNull 是否移除null值
     * @param <E>        Entity
     * @param <V>        Vo
     * @return Vo
     */
    public static <E, V> V e2v(E source, Class<V> vClass, Boolean removeNull) {
        if (null == source) {
            return null;
        }
        List<V> vList = e2vList(Collections.singletonList(source), vClass, removeNull);

        return vList.get(0);
    }
}
