package com.zbs.compressPdf;

import com.aspose.pdf.Document;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * https://www.cnblogs.com/zhexuejun/p/13257522.html
 * pdf、图片压缩【 com.aspose.pdf 收费版】
 * https://www.it610.com/article/1283115038390894592.htm
 */
public class CompressPdfByAspose {

    /**
     * 将文件转换成byte数组
     *
     * @param filePath
     * @return
     */
    public static byte[] File2byte(File filePath) {
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 图片压缩
     *
     * @param source 源图片 filePath + fileName
     * @param target 目标图片 filePath + fileName
     */
    public static void optimizeImage(String source, String target) {
        File file = new File(source);
        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(new ByteArrayInputStream(File2byte(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thumbnails.of(originalImage) //原图片
                    .scale(0.5) //分辨率比例
                    .outputQuality(0.25f) //图片质量
                    .outputFormat("JPEG") //目标文件格式
                    .toFile(target); //目标图片
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void optimize(String source, String target) {
        Document doc = new Document(source);
        //设置压缩属性
        Document.OptimizationOptions opt = new Document.OptimizationOptions();
        //删除PDF不必要的对象
        opt.setRemoveUnusedObjects(true);
        //链接重复流
        opt.setLinkDuplcateStreams(false);
        //删除未使用的流
        opt.setRemoveUnusedStreams(false);
        //删除不必要的字体
        opt.setUnembedFonts(true);
        //压缩PDF中的图片
        opt.setCompressImages(true);
        //图片压缩比， 0 到100可选，越低压缩比越大
        opt.setImageQuality(5);
        doc.optimizeResources(opt);
        //优化web的PDF文档
        doc.optimize();
        doc.save(target);
    }

    public static void main(String[] args) {
        String source = "D:/CONTRACT_SUPPLY_30795161.pdf";
        String target = "D:/new/CONTRACT_SUPPLY_30795161.pdf";
        long a = System.currentTimeMillis();
        optimize(source, target);
        long b = System.currentTimeMillis();
        int c = (int) ((b - a) / 1000);
        System.out.println(c);
    }
}
