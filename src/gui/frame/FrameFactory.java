package gui.frame;

import boot.GUIComponentsParameter;

import javax.swing.*;
import java.util.HashMap;

public class FrameFactory {
    private static final HashMap<JPanel, JFrame> collector = new HashMap<>();

    private FrameFactory(){}

    public static JFrame getFrame(JPanel panel) {
        if (collector.containsKey(panel)) return collector.get(panel);
        JFrame frame = new JFrame(panel.getName());
        frame.setTitle(panel.getName());
        frame.setIconImage(GUIComponentsParameter.getIcoImage());
        frame.add(panel);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setLocation(GUIComponentsParameter.PERCENTAGE_FRAME_X, 0);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.repaint();
        collector.put(panel, frame);
        return frame;
    }
}
