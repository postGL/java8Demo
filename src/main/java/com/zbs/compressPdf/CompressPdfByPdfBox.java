package com.zbs.compressPdf;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * description: CompressPdfByPdfBox
 * date: 2021/2/24 15:47
 * author: zhangbs
 * version: 1.0
 */
public class CompressPdfByPdfBox {
    public static void main(String[] args) throws IOException {
        long a = System.currentTimeMillis();
        compressPDFContent("D:/jinshu.pdf", "D:/pdfBox_port.pdf");
        long b = System.currentTimeMillis();
        int c = (int) ((b - a) / 1000);
        System.out.println(c + "秒");
    }

    public static void compressPDFContent(String inFilePath, String outFilePath) throws IOException {
        File file = new File(inFilePath);

        PDDocument doc = PDDocument.load(file);
        Map<String, COSBase> fontFileCache = new HashMap<>();
        for (int pageNumber = 0; pageNumber < doc.getNumberOfPages(); pageNumber++) {
            final PDPage page = doc.getPage(pageNumber);
            COSDictionary pageDictionary = (COSDictionary) page.getResources().getCOSObject().getDictionaryObject(COSName.FONT);
//            COSDictionary pageDictionary = page.getResources().getCOSObject();
            for (COSName currentFont : pageDictionary.keySet()) {
                COSDictionary fontDictionary = (COSDictionary) pageDictionary.getDictionaryObject(currentFont);
                for (COSName actualFont : fontDictionary.keySet()) {
                    COSBase actualFontDictionaryObject = fontDictionary.getDictionaryObject(actualFont);
                    if (actualFontDictionaryObject instanceof COSDictionary) {
                        COSDictionary fontFile = (COSDictionary) actualFontDictionaryObject;
                        if (fontFile.getItem(COSName.FONT_NAME) instanceof COSName) {
                            COSName fontName = (COSName) fontFile.getItem(COSName.FONT_NAME);
                            fontFileCache.computeIfAbsent(fontName.getName(), key -> fontFile.getItem(COSName.FONT_FILE2));
                            fontFile.setItem(COSName.FONT_FILE2, fontFileCache.get(fontName.getName()));
                        }
                    }
                }
            }
        }

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        doc.save(baos);
        final File compressed = new File(outFilePath);
        baos.writeTo(new FileOutputStream(compressed));
    }
}
