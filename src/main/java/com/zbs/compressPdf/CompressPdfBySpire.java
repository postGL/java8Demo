package com.zbs.compressPdf;

import com.spire.pdf.PdfCompressionLevel;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.exporting.PdfImageInfo;
import com.spire.pdf.graphics.PdfBitmap;

/**
 * description: compressPdf 压缩pdf文件-免费版
 * 冰蓝科技为每个产品都提供试用版本，每个注册用户都可以在我们网站免费下载并试用产品，试用版对产品功能不做任何限制，
 * 不过试用版本将在结果文档中添加一个额外的包含评估信息的工作表（Spire.XLS）或者一行警告信息。
 * 当你购买一项许可证后，你将通过邮件获得一个.xml格式的许可证文件。应用这一文件后，警告信息就会消失。
 * date: 2021/2/24 10:33
 * author: zhangbs
 * version: 1.0
 */
public class CompressPdfBySpire {

    public static void main(String[] args) {
//        compressPDFContent("D:/123.pdf");
        long a = System.currentTimeMillis();
        compressPDFImages("D:/123.pdf");
        long b = System.currentTimeMillis();
        int c = (int) ((b - a) / 1000);
        System.out.println(c + "秒");
    }

    public static void compressPDFContent(String filePath) {
        //加载PDF示例文档
        //        PdfDocument document = new PdfDocument("C:\\Users\\Test1\\Desktop\\Sample.pdf");
        PdfDocument document = new PdfDocument(filePath);

        //禁用incremental update
        document.getFileInfo().setIncrementalUpdate(false);

        //设置PDF文档的压缩级别
        document.setCompressionLevel(PdfCompressionLevel.Best);

        //保存并关闭文档
        document.saveToFile("D:/456.pdf");
        document.close();
    }

    public static void compressPDFImages(String filePath) {
        //加载PDF文档
        PdfDocument document = new PdfDocument(filePath);

        //禁用incremental update
        document.getFileInfo().setIncrementalUpdate(false);

        //遍历文档所有页面
        for (int i = 0; i < document.getPages().getCount(); i++) {
            //提取页面中的图片
            PdfPageBase page = document.getPages().get(i);
            PdfImageInfo[] images = page.getImagesInfo();
            if (images != null && images.length > 0) {
                //遍历所有图片
                for (int j = 0; j < images.length; j++) {
                    PdfImageInfo image = images[j];
                    PdfBitmap bp = new PdfBitmap(image.getImage());
                    //降低图片的质量
                    bp.setQuality(10);
                    //用压缩后的图片替换原文档中的图片
                    page.replaceImage(j, bp);
                }
            }
        }
        //保存并关闭文档
        document.saveToFile("D:/789(1).pdf");
        document.close();
    }

}
