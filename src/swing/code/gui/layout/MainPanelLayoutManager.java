package swing.code.gui.layout;

import swing.code.form.ComponentSize;

import java.awt.*;

public class MainPanelLayoutManager implements LayoutManager {
    private Dimension size = new Dimension();

    @Override
    public void addLayoutComponent(String name, Component comp) {}

    @Override
    public void removeLayoutComponent(Component comp) {}

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
        Component list[] = parent.getComponents();
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

    private Dimension getWidgetPanelSize(){
        return new Dimension(ComponentSize.PANEL_WIDTH,ComponentSize.MAIN_PANEL_HEIGHT);
    }

    private Dimension calculateBestSize(Container container) {
        // Вычисление длины контейнера
        Component[] list = container.getComponents();
        int maxWidth = 0;
        for (Component current : list) {
            int width = current.getWidth();
            // Поиск компонента с максимальной длиной
            if ( width > maxWidth )
                maxWidth = width;
        }
        // Размер контейнера в длину с учетом левого отступа
        size.width = maxWidth + 5;
        // Вычисление высоты контейнера
        int height = 0;
        for (Component current : list) {
            height += 5;
            height += current.getHeight();
        }
        size.height = height;
        return size;
    }
}
