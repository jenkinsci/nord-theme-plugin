package io.jenkins.plugins.theme.nord;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;
import java.util.List;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class NordTheme extends ThemeManagerFactory {

    static final String CSS = "nord.css";
    static final String ID = "nord";

    @DataBoundConstructor
    public NordTheme() {
        // Stapler
    }

    @Override
    public Theme getTheme() {
        return Theme.builder().withCssUrls(List.of(getCssUrl())).build();
    }

    @Extension
    @Symbol("nord")
    public static class DescriptorImpl extends ThemeManagerFactoryDescriptor {

        @Override
        public String getThemeKey() {
            return ID;
        }

        @Override
        public ThemeManagerFactory getInstance() {
            return new NordTheme();
        }

        @Override
        public String getThemeCssSuffix() {
            return CSS;
        }

        @NonNull
        @Override
        public String getDisplayName() {
            return "Nord";
        }

        @Override
        public String getIconClassName() {
            return "symbol-nord plugin-nord-theme";
        }

        @Override
        public String getThemeId() {
            return ID;
        }

        @Override
        public boolean isNamespaced() {
            return true;
        }
    }
}
