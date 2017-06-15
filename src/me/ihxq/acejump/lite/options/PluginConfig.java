package me.ihxq.acejump.lite.options;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

@State(
        name = "emacsIDEAsPluginConfig",
        storages = {
                @Storage(
                        id = "other",
                        file = "$APP_CONFIG$/emacsIDEAs_plugin.xml")
        }
)
public class PluginConfig implements PersistentStateComponent<PluginConfig> {
    int _firstJumpBackground = Color.blue.getRGB();
    int _firstJumpForeground = Color.white.getRGB();
    int _secondJumpBackground = Color.red.getRGB();
    int _secondJumpForeground = Color.white.getRGB();
    boolean _needSelectTextAfterJump = true;
    public boolean _jumpBehind = true;
    int _panelBackground = Color.lightGray.getRGB();
    public boolean _toUpperCase = true;

    public Color getFirstJumpBackground() {
        return new Color(_firstJumpBackground);
    }

    public Color getFirstJumpForeground() {
        return new Color(_firstJumpForeground);
    }

    public Color getSecondJumpBackground() {
        return new Color(_secondJumpBackground);
    }

    public Color getSecondJumpForeground() {
        return new Color(_secondJumpForeground);
    }

    public Color getPanelBackground() {
        return new Color(_panelBackground);
    }

    @Nullable
    @Override
    public PluginConfig getState() {
        return this;
    }

    @Override
    public void loadState(PluginConfig config) {
        XmlSerializerUtil.copyBean(config, this);
    }

    @Nullable
    public static PluginConfig getInstance(Project project) {
        return ServiceManager.getService(project, PluginConfig.class);
    }
}
