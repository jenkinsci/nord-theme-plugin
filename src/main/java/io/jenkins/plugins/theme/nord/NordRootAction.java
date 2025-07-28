package io.jenkins.plugins.theme.nord;

import hudson.Extension;
import hudson.Plugin;
import hudson.model.UnprotectedRootAction;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jenkins.model.Jenkins;
import org.kohsuke.stapler.StaplerRequest2;
import org.kohsuke.stapler.StaplerResponse2;

@Extension
public class NordRootAction implements UnprotectedRootAction {

    @Override
    public String getIconFileName() {
        return null; /* no UI */
    }

    @Override
    public String getDisplayName() {
        return null; /* no UI */
    }

    @Override
    public String getUrlName() {
        return "theme-" + NordTheme.ID;
    }

    public void doDynamic(StaplerRequest2 req, StaplerResponse2 rsp) throws IOException, ServletException {
        String cssFile = req.getRestOfPath();
        if (cssFile.startsWith("/")) {
            cssFile = cssFile.substring(1);
        }
        if (!NordTheme.CSS.equals(cssFile)) {
            rsp.sendError(404);
            return;
        }
        final Plugin plugin = Jenkins.get().getPlugin("nord-theme");
        if (plugin == null) {
            rsp.sendError(404);
            return;
        }
        plugin.doDynamic(req, rsp);
    }
}
