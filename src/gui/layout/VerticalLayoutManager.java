package gui.layout;

import java.awt.*;

public class VerticalLayoutManager implements LayoutManager {
    private int width;
    private int height;
    private Dimension size;

    public VerticalLayoutManager(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public VerticalLayoutManager(Dimension size) {
        this.size = size;
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return getWidgetPanelSize();
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return getWidgetPanelSize();
    }

    @Override
    public void layoutContainer(Container parent) {
        // Список компонентов
        Component[] list = parent.getComponents();
        int currentY = 5;
        for (Component current : list) {
            // Определение предпочтительного размера компонента
            Dimension pref = current.getPreferredSize();
            // Размещение компонента на экране
            current.setBounds(5, currentY, pref.width, pref.height);
            // Учитываем промежуток в 5 пикселов
            currentY += 5;
            // Смещаем вертикальную позицию компонента
            currentY += pref.height;
        }
    }

    private Dimension getWidgetPanelSize() {
        return new Dimension(width, height);
    }
}
