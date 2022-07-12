package gui.panel.percentageresponse;

import boot.Bank;
import boot.GUIComponentsParameter;
import gui.component.content.LabelForContentPanel;
import gui.panel.MainPanel;
import util.text.DigitParser;

import javax.swing.*;
import java.time.LocalDate;

public class PercentageResponseLogicPanel extends MainPanel {
    private final JLabel idLabel = new LabelForContentPanel("ІПН:");
    private final JTextField idField = getTextField();
    private final JLabel nameLabel = new LabelForContentPanel("Ім'я:");
    private final JTextField nameField = getTextField();
    private final JLabel ompLabel = new LabelForContentPanel("ОМП:");
    private final JTextField ompField = getTextField();
    private final JLabel thisDebtGraceLabel = new LabelForContentPanel("Поточна грейсова заборгованість:");
    private final JTextField thisDebtGraceField = getTextField();
    private final JLabel thisDebtNongraceLabel = new LabelForContentPanel("Поточна негрейсова заборгованість:");
    private final JTextField thisDebtNongraceField = getTextField();
    private final JLabel expiratedDebtGraceLabel = new LabelForContentPanel("Прострочена грейсова заборгованість:");
    private final JTextField expiratedDebtGraceField = getTextField();
    private final JLabel exDebtGraceLabel = new LabelForContentPanel("Минула грейсова заборгованість:");
    private final JTextField exDebtGraceField = getTextField();
    private final JLabel exDebtNongraceLabel = new LabelForContentPanel("Минула негрейсова заборгованість:");
    private final JTextField exDebtNongraceField = getTextField();
    private final JLabel countedPercentagesLabel = new LabelForContentPanel("Нараховані відсотки:");
    private final JTextField countedPercentagesField = getTextField();
    private final JLabel overdraftLabel = new LabelForContentPanel("Технічний овердрафт:");
    private final JTextField overdraftField = getTextField();
    private final JLabel predictionOnDayLabel = new LabelForContentPanel("День прогнозу:");
    private final JTextField predictionOnDayField = getTextField();
    private final JLabel predictedDebtGracePercentageLabel = new LabelForContentPanel("Прогноз відсотків на грейсову заборгованість:");
    private final JTextField predictedDebtGracePercentageField = getTextField();
    private final JLabel predictedNongracePercentageLabel = new LabelForContentPanel("Прогноз відсотків на негрейсову заборгованість:");
    private final JTextField predictedNongracePercentageField = getTextField();
    private final JLabel predictedFullPercentageLabel = new LabelForContentPanel("Прогноз відсотків на всю заборгованість:");
    private final JTextField predictedFullPercentageField = getTextField();
    private final JLabel percentageGracePerDayLabel = new LabelForContentPanel("Відсотки на грейс/день:");
    private final JTextField percentageGracePerDayField = getTextField();
    private final JLabel percentageNonracePerDayLabel = new LabelForContentPanel("Відсотки на негрейс/день:");
    private final JTextField percentageNonracePerDayField = getTextField();
    private final JLabel percentageAllPerDayLabel = new LabelForContentPanel("Відсотки загально/день:");
    private final JTextField percentageAllPerDayField = getTextField();
    private final JLabel predictedFullDebtLabel = new LabelForContentPanel("Прогноз до повного погашення заборгованостей:");
    private final JTextField predictedFullDebtField = getTextField();

    public PercentageResponseLogicPanel() {
        super(GUIComponentsParameter.getPercentageGeneratorPanelDimension());
        setBackground(GUIComponentsParameter.contentPanelBackgroundColor);
        ompField.setEditable(false);
        predictedFullDebtField.setEditable(false);
        predictedFullPercentageField.setEditable(false);
        percentageGracePerDayField.setEditable(false);
        percentageNonracePerDayField.setEditable(false);
        percentageAllPerDayField.setEditable(false);

        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(ompLabel);
        add(ompField); //unchangeable
        add(thisDebtGraceLabel);
        add(thisDebtGraceField);
        add(thisDebtNongraceLabel);
        add(thisDebtNongraceField);
        add(expiratedDebtGraceLabel);
        add(expiratedDebtGraceField);
        add(exDebtGraceLabel);
        add(exDebtGraceField);
        add(exDebtNongraceLabel);
        add(exDebtNongraceField);
        add(countedPercentagesLabel);
        add(countedPercentagesField);
        add(overdraftLabel);
        add(overdraftField);
        add(predictionOnDayLabel);
        add(predictionOnDayField);
        add(predictedNongracePercentageLabel);
        add(predictedNongracePercentageField);
        add(predictedDebtGracePercentageLabel);
        add(predictedDebtGracePercentageField);
        add(predictedFullPercentageLabel);
        add(predictedFullPercentageField);  //unchangeable
        add(percentageGracePerDayLabel);
        add(percentageGracePerDayField);
        add(percentageNonracePerDayLabel);
        add(percentageNonracePerDayField);
        add(percentageAllPerDayLabel);
        add(percentageAllPerDayField);
        add(predictedFullDebtLabel);
        add(predictedFullDebtField);  //unchangeable
    }

    private void calculate() {
        double omp;
        double predictedFullPercentage;
        double predictedFullDebt;
        double gracePerDay = Bank.getGracePercentPerDay()*DigitParser.toDouble(expiratedDebtGraceField.getText())/100;
        double nongracePerDay = Bank.getNonGracePercentPerDay()*(DigitParser.toDouble(thisDebtNongraceField.getText()) + DigitParser.toDouble(exDebtNongraceField.getText()))/100;

        omp = DigitParser.toDouble(countedPercentagesField.getText()) + DigitParser.toDouble(overdraftField.getText());
        ompField.setText(String.valueOf(omp));
        predictedFullPercentage = DigitParser.toDouble(predictedDebtGracePercentageField.getText()) + DigitParser.toDouble(predictedNongracePercentageField.getText());
        predictedFullPercentageField.setText(String.valueOf(predictedFullPercentage));
        predictedFullDebt = omp +
                predictedFullPercentage +
                DigitParser.toDouble(thisDebtGraceField.getText()) +
                DigitParser.toDouble(thisDebtNongraceField.getText()) +
                DigitParser.toDouble(expiratedDebtGraceField.getText()) +
                DigitParser.toDouble(exDebtGraceField.getText()) +
                DigitParser.toDouble(exDebtNongraceField.getText());
        percentageGracePerDayField.setText(String.valueOf(gracePerDay));
        percentageNonracePerDayField.setText(String.valueOf(nongracePerDay));
        percentageAllPerDayField.setText(String.valueOf(gracePerDay + nongracePerDay));
        predictedFullDebtField.setText(String.valueOf(predictedFullDebt));
    }

    @Override
    public String getAllText() {
        calculate();
        String divider = "/";
        String thisMonth = divider + (LocalDate.now().getMonthValue() < 10 ? "0" : "") + LocalDate.now().getMonthValue() + divider + LocalDate.now().getYear();
        String date = (predictionOnDayField.getText().trim().length() == 1 ? "0" : "") + predictionOnDayField.getText().trim() + thisMonth;
        String thisPeriod = "01" + thisMonth + " - " + date;
        return nameField.getText() +
                ", дякуємо за очікування. Надаємо деталізований стан використаних кредитних коштів, розміру обов'язкового місячного платежу та прогнозованих відсотків на дату: " +
                date +
                '\n' +
                (thisDebtGraceField.getText().trim().equals("") ? "" : "Використані кредитні кошти (покупка товарів/послуг), пільговий період на які діє до кінця наступного місяця: " + thisDebtGraceField.getText() + " грн.\n") +
                (exDebtGraceField.getText().trim().equals("") ? "" : "Використані кредитні кошти (покупка товарів/послуг), пільговий період на які закінчується цього місяця (у разі невнесення будуть нараховані відсотки у розмірі 0,16%/день на денну заборгованість кожного дня періоду): " + exDebtGraceField.getText() + " грн.\n") +
                (expiratedDebtGraceField.getText().trim().equals("") ? "" : "Використані кредитні кошти (покупка товарів/послуг), на які закінчився пільговий період (вже нараховується 0,16%/день на денну заборгованість): " + expiratedDebtGraceField.getText() + " грн.\n") +
                (thisDebtNongraceField.getText().trim().equals("") ? "" : "Використані кредитні кошти (зняття/переказ у рахунок кредитних коштів) цього місяця, на які не діє пільговий період (відсотки нараховуються з дня здійснення операції у розмірі 0,22%/день на денну заборгованість): " + thisDebtNongraceField.getText() + " грн.\n") +
                (exDebtNongraceField.getText().trim().equals("") ? "" : "Використані кредитні кошти (зняття/переказ у рахунок кредитних коштів) станом на кінець минулого місяця, на які не діє пільговий період (відсотки нараховуються з дня здійснення операції у розмірі 0,22%/день на денну заборгованість): " + exDebtNongraceField.getText() + " грн.\n") +
                (countedPercentagesField.getText().trim().equals("") ? "" : "Нараховані відсотки станом на кінець минулого місяця: " + countedPercentagesField.getText() + " грн.\n") +
                (overdraftField.getText().trim().equals("") ? "" : "Розмір несанкціонованого овердрафту (формується у разі використання коштів, які мали бути списані для сплати обов'язкового місячного платежу): " + overdraftField.getText() + " грн.\n") +
                (ompField.getText().trim().equals("") ? "" : "Розмір обов'язкого місячного платежу цього місяця: " + ompField.getText() + " грн.\n") +
                (predictedDebtGracePercentageField.getText().trim().equals("") ? "" : "Прогнозована сума відсотків на " + thisPeriod + " на суму операцій покупки товарів/послуг, пільговий період за які закінчився: " + predictedDebtGracePercentageField.getText() + " грн.\n") +
                (predictedNongracePercentageField.getText().trim().equals("") ? "" : "Прогнозована сума відсотків на " + thisPeriod + " на суму операцій зняття/переказу кредитних коштів, на які не діє пільговий період: " + predictedNongracePercentageField.getText() + " грн.\n") +
                (predictedFullPercentageField.getText().trim().equals("") ? "" : "Загальна сума прогнозованих відсотків на " + thisPeriod + " становить: " + predictedFullPercentageField.getText() + " грн.\n") +
                (predictedFullDebtField.getText().trim().equals("") ? "" : "Загальна сума до повного погашення на дату " + thisPeriod + " становить: " + predictedFullDebtField.getText() + " грн.\n");
    }
}
