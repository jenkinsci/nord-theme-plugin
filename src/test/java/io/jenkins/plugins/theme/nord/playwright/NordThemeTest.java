package io.jenkins.plugins.theme.nord.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.junit.jupiter.WithJenkins;

@WithJenkins
@UsePlaywright(PlaywrightConfig.class)
public class NordThemeTest {

    @Test
    void themeLoads(JenkinsRule j, Page p) {
        Theme theme = Theme.NORD;
        new AppearancePage(p, j.jenkins.getRootUrl())
                .goTo()
                .themeIsPresent(theme)
                .selectTheme(theme)
                .themeIsApplied(theme);
    }
}
