package de.VBKA.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    private UUID id;
    private BankAccount bankAccount;
    private LocalDate bookedDate;
    private String paymentParty; //Zahlungsbeteiligter
    private BankAccount bankAccountPaymentParty;
    private String bookingType; //Buchungsart z.B. Kartenzahlung, Lohn/Gehalt/Rente, Basislastschrift etc.
    private String purposeOfUse; //Verwendungszweck
    private int amountInCents;
    private int balanceAfterBooking;
    private List<Category> categories;

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bankAccount=" + bankAccount +
                ", bookedDate=" + bookedDate +
                ", paymentParty='" + paymentParty + '\'' +
                ", bankAccountPaymentParty=" + bankAccountPaymentParty +
                ", bookingType='" + bookingType + '\'' +
                ", purposeOfUse='" + purposeOfUse + '\'' +
                ", amountInCents=" + amountInCents +
                ", balanceAfterBooking=" + balanceAfterBooking +
                ", categories=" + categories +
                '}';
    }
}
