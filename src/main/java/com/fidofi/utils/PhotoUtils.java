package com.fidofi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by fido on 2018/1/3.
 * 生成的照片相关的配置
 * 包括命名与存放的位置
 */
public class PhotoUtils {

    /**
     * 随机生成图片的名字
     * 上传时间+六位随机数
     * @return
     */
    public static String getPhotoName() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String time = format.format(new Date());
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return time + number;
    }
}
