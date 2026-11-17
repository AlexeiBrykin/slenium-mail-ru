package ru.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

class MainPage {
    final static String LINK = "https://mail.ru";

    static void closeAllBanners(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript(
                "// 1. Удалить полноэкранный canvas-оверлей r.mail.ru/redir\n" +
                        "document.querySelectorAll('a[href*=\"r.mail.ru/redir\"]').forEach(a => a.remove());\n" +
                        "// 2. Клик по крестикам VK Ads баннеров\n" +
                        "document.querySelectorAll('svg[viewBox=\"0 0 22 22\"]').forEach(svg => {\n" +
                        "  const btn = svg.closest('div[style*=\"display: flex\"]');\n" +
                        "  if (btn) btn.click();\n" +
                        "});\n" +
                        "// 3. Удалить оставшиеся VK Ads контейнеры с меткой «Реклама»\n" +
                        "document.querySelectorAll('img._mk_vkAdIconImg').forEach(icon => {\n" +
                        "  let node = icon;\n" +
                        "  for (let i = 0; i < 6 && node; i++) {\n" +
                        "    if (node.querySelector('img[src*=\"mradx.net\"]')) { node.remove(); return; }\n" +
                        "    node = node.parentElement;\n" +
                        "  }\n" +
                        "});"
        );
    }
}
