package gui.frame;

import boot.AnalyticCollector;
import boot.GUIComponentsParameter;
import gui.panel.callanalyticgenerator.CallAnalyticPanel;
import gui.panel.percentageresponse.PercentageResponseMainPanel;
import gui.panel.percentageresponse.RawResultPanel;
import gui.panel.requestgenerator.RequestPanelFactory;
import gui.panel.saver.SavedPanel;
import gui.panel.scriptgenerator.ScriptPanel;
import util.file.FilePathLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {
    private boolean openInNewWindow = false;
    private boolean alwaysOnTop = true;
    private JPanel currentPanel;

    public MainFrame() {
        JMenuBar menu = new JMenuBar();
        JMenu requestMenu = new JMenu();
        requestMenu.setText("Запити");
        RequestPanelFactory.getPanels().forEach(panel -> addCallablePanel(requestMenu, panel));
        menu.add(requestMenu);

        JMenu percentageResponseMenu = new JMenu();
        percentageResponseMenu.setText("Відсотки");
        addCallablePanel(percentageResponseMenu, PercentageResponseMainPanel.getInstance());
        addCallablePanel(percentageResponseMenu, RawResultPanel.getInstance());
        menu.add(percentageResponseMenu);

        JMenu scriptMenu = new JMenu();
        scriptMenu.setText("Скрипти");
        addCallablePanel(scriptMenu, ScriptPanel.NAME, ScriptPanel.class);
        addCallablePanel(scriptMenu, CallAnalyticPanel.NAME, CallAnalyticPanel.class);
        scriptMenu.addSeparator();
        addCallableItem(scriptMenu, "Відкрити скрипти чату", a -> openFile(FilePathLoader.getInstance().getUserScriptsFile()));
        addCallableItem(scriptMenu, "Відкрити скрипти дзвінків", a -> openFile(FilePathLoader.getInstance().getCallButtonNamesFile()));

        menu.add(scriptMenu);

        JMenu savedMenu = new JMenu();
        savedMenu.setText("Збережені");
        addCallablePanel(savedMenu, SavedPanel.getInstance());
        addCallableItem(savedMenu, "Відкрити історію", a -> openFile(FilePathLoader.getInstance().getHistoryFile()));
        savedMenu.addSeparator();
        addCallableItem(savedMenu, "Очистити збережене", a -> {
            FilePathLoader.getInstance().getCurrentSavedFile().delete();
            SavedPanel.getInstance().removeText();
        });
        addCallableItem(savedMenu, "Видалити файл історії", a -> FilePathLoader.getInstance().getHistoryFile().delete());
        savedMenu.addSeparator();
        addCallableItem(savedMenu, "Відкрити місячну статистику", a -> openFile(AnalyticCollector.getInstance().getAnalytic().getMonthAnalyticFile()));
        addCallableItem(savedMenu, "Відкрити поточну аналітику", a -> openFile(AnalyticCollector.getInstance().getAnalytic().getCurrentAnalyticFile()));
        menu.add(savedMenu);

        JMenu settingMenu = new JMenu();
        settingMenu.setText("Налаштування");
        addCallableOptionalItem(settingMenu, "Відкривати в новому вікні", false, a -> setOpenInNewFrame());
        addCallableOptionalItem(settingMenu, "Завжди поверх інших вікон", true, a -> setAlwaysOnTop());
        settingMenu.addSeparator();
        addCallableItem(settingMenu, "Вихід", a -> {
            AnalyticCollector.getInstance().save();
            System.exit(0);
        });
        menu.add(settingMenu);
        setDefaultFont(requestMenu, percentageResponseMenu, scriptMenu, savedMenu, settingMenu);

        setJMenuBar(menu);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        currentPanel = RequestPanelFactory.getPanels().get(0);
        add(currentPanel);
        setAlwaysOnTop(alwaysOnTop);
        setTitle("My CRM [ver. 0.6] @valdis95");
        setIconImage(GUIComponentsParameter.getIcoImage());
        pack();
    }

    private void setDefaultFont(JComponent... components) {
        for (JComponent component : components) {
            component.setFont(GUIComponentsParameter.getControlPanelFont());
        }
    }

    private void setOpenInNewFrame() {
        openInNewWindow = !openInNewWindow;
    }

    private void setAlwaysOnTop(){
        alwaysOnTop = !alwaysOnTop;
        setAlwaysOnTop(alwaysOnTop);
    }

    private void setContentPanel(JPanel panel) {
        if (panel.equals(currentPanel)) return;

        if (openInNewWindow) {
            FrameFactory.getFrame(panel).setVisible(true);
        } else {
            remove(currentPanel);
            currentPanel = panel;
            add(currentPanel);
            repaint();
            pack();
        }
    }

    private void addCallablePanel(JMenu menu, JPanel panel) {
        JMenuItem item = new JMenuItem(panel.getName());
        item.addActionListener(a -> setContentPanel(panel));
        setDefaultFont(item);
        menu.add(item);
    }

    private void addCallablePanel(JMenu menu, String itemName, Class<? extends JPanel> aClass){
        JMenuItem item = new JMenuItem();
        item.setText(itemName);
        setDefaultFont(item);
        menu.add(item);
        item.addActionListener(a -> {
            JPanel panel = null;
            try{
                panel = aClass.getDeclaredConstructor().newInstance();
            } catch (Exception e){
                panel = new JPanel();
                panel.setName("EMPTY PANEL");
                panel.setPreferredSize(new Dimension(400, 100));
                panel.add(new JLabel(e.getMessage()));
            } finally {
                setContentPanel(panel);
            }
        });

    }

    private void addCallableItem(JMenu menu, String itemName, ActionListener listener) {
        JMenuItem item = new JMenuItem(itemName);
        item.addActionListener(listener);
        setDefaultFont(item);
        menu.add(item);
    }

    private void addCallableOptionalItem(JMenu menu, String itemName, boolean isSelected, ActionListener listener) {
        JCheckBoxMenuItem item = new JCheckBoxMenuItem(itemName);
        item.setSelected(isSelected);
        item.addActionListener(listener);
        setDefaultFont(item);
        menu.add(item);
    }

    private void openFile(File file){
        try {
            if (Desktop.isDesktopSupported())
                Desktop.getDesktop().edit(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
