package pl.coderslab.Classes;

import java.math.BigDecimal;

public class Employees {

        public Employees(){

        }

        private int id;
        private String name;
        private String lastName;

        public Employees(String name, String lastName) {
                this.name = name;
                this.lastName = lastName;
        }

        private String address;
        private String phone;
        private String note;
        private BigDecimal hourlyPayment;

        @Override
        public String toString() {
                return "id=" + id +
                        ", name='" + name + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", address='" + address + '\'' +
                        ", phone='" + phone + '\'' +
                        ", note='" + note + '\'' +
                        ", hourlyPayment=" + hourlyPayment + "<br>  ";
        }

        public Employees(String name, String lastName, String address, String phone, String note, BigDecimal hourlyPayment) {

                this.name = name;
                this.lastName = lastName;
                this.address = address;
                this.phone = phone;
                this.note = note;
                this.hourlyPayment = hourlyPayment;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getNote() {
                return note;
        }

        public void setNote(String note) {
                this.note = note;
        }

        public BigDecimal getHourlyPayment() {
                return hourlyPayment;
        }

        public void setHourlyPayment(BigDecimal hourlyPayment) {
                this.hourlyPayment = hourlyPayment;
        }
}
