package swing.code.gui.panel;

import swing.code.form.MainPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PanelFactory {
    private static List<MainPanel> panels;

    public static List<MainPanel> getPanels(){
        if(panels == null) generatePanels();
        return panels;
    }

    private static void generatePanels(){
        panels = new ArrayList<>();
        panels.add(MainRequestPanel.getInstance());
        panels.add(VerificationPanel.getInstance());
        panels.add(ReferralPanel.getInstance());
        panels.add(CashBackPanel.getInstance());
        panels.add(ClosingAccountPanel.getInstance());
        panels.add(FraudPanel.getInstance());
        panels.add(EnquiryPanel.getInstance());
        panels.add(DeliveryPanel.getInstance());
        panels.add(OtherRequestPanel.getInstance());
        panels.add(MainRequestPanel.getInstance());
    }


}
