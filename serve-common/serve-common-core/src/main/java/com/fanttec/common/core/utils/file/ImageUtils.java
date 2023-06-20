package com.fanttec.common.core.utils.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Optional;

/**
 * 图片处理工具类
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月20日 星期二 15时43分01秒
 **/
@Slf4j
public class ImageUtils {

    public static byte[] getImage(String imagePath) {
        Optional<InputStream> fileOptional = Optional.ofNullable(getFile(imagePath));
        if(fileOptional.isPresent()){
            InputStream inputStream = fileOptional.get();
            try {
                return IOUtils.toByteArray(inputStream);
            } catch (Exception e) {
                log.error("图片加载异常 {}",  e.getMessage());
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }else log.error("图片加载为空");
        return null;
    }

    public static InputStream getFile(String imagePath) {
        Optional< byte[]> fileOptional = Optional.ofNullable(readFile(imagePath));
        if(fileOptional.isPresent()){
            byte[] result = fileOptional.get();
            try {
                result = Arrays.copyOf(result, result.length);
                return new ByteArrayInputStream(result);
            } catch (Exception e) {
                log.error("获取图片异常 {}",  e.getMessage());
            }
        }else log.error("图片加载为空");
        return null;
    }

    /**
     * 读取文件为字节数据
     *
     * @param url 地址
     * @return 字节数据
     */
    public static byte[] readFile(String url) {
        InputStream in = null;
        try {
            // 网络地址
            URL urlObj = new URL(url);
            URLConnection urlConnection = urlObj.openConnection();
            urlConnection.setConnectTimeout(30 * 1000);
            urlConnection.setReadTimeout(60 * 1000);
            urlConnection.setDoInput(true);
            in = urlConnection.getInputStream();
            return IOUtils.toByteArray(in);
        } catch (Exception e) {
            log.error("访问文件异常 {}",  e.getMessage());
            return null;
        } finally {
            IOUtils.closeQuietly(in);
        }
    }
}
