package com.ruiyun.example;

import com.ruiyun.jvppeteer.core.Puppeteer;
import com.ruiyun.jvppeteer.core.browser.Browser;
import com.ruiyun.jvppeteer.core.page.Page;
import com.ruiyun.jvppeteer.options.LaunchOptions;
import com.ruiyun.jvppeteer.options.LaunchOptionsBuilder;

import java.util.ArrayList;

public class PageTracingExample {

    public static void main(String[] args) throws Exception {
        //String path = new String("F:\\java教程\\49期\\vuejs\\puppeteer\\.local-chromium\\win64-722234\\chrome-win\\chrome.exe".getBytes(),"UTF-8");
        ArrayList<String> argList = new ArrayList<>();
        String path = "D:\\develop\\project\\toString\\chrome-win\\chrome.exe";

        LaunchOptions options = new LaunchOptionsBuilder().withArgs(argList).withHeadless(true).withExecutablePath(path).build();
        argList.add("--no-sandbox");
        argList.add("--disable-setuid-sandbox");
        Browser browser = Puppeteer.launch(options);

        Page page = browser.newPage();
        //开启追踪
        page.tracing().start("C:\\Users\\howay\\Desktop\\trace.json");
        page.goTo("https://www.baidu.com/?tn=98012088_10_dg&ch=3");
        page.tracing().stop();
        //waifor tracingComplete

    }
}
