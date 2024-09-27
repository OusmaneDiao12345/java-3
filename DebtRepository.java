package repositories;

import entities.Debt;

import java.util.ArrayList;
import java.util.List;

public class DebtRepository {
    private List<Debt> debts = new ArrayList<>();

    public void addDebt(Debt debt) {
        debts.add(debt);
    }

    public List<Debt> getDebts() {
        return debts;
    }

    public List<Debt> getUnpaidDebts() {
        List<Debt> result = new ArrayList<>();
        for (Debt debt : debts) {
            if (debt.getAmountRemaining() > 0) {
                result.add(debt);
            }
        }
        return result;
    }

    public void archiveDebt(Debt debt) {
        debt.setStatus("Soldée");
    }
}
