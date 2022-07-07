package com.heima.tess4j;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class Application {

    /**
     * 识别图片中的文字
     * @param args
     */
    public static void main(String[] args) throws TesseractException {
        // 创建实例
        ITesseract tesseract = new Tesseract();

        //设置字体库路径
        tesseract.setDatapath("F:\\workspace\\tessdata");

        //设置语言——简体中文
        tesseract.setLanguage("chi_sim");

        File file = new File("F:\\开发素材\\test.png");

        // 识别图片
        String result = tesseract.doOCR(file);

        System.out.println(result.replaceAll("\\r|\\n","-"));

    }
}
