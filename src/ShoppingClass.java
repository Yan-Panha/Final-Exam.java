
    interface DiscountRate {
        double getServiceMemberDiscount();
        double getProductMemberDiscount();
    }


    class Customer implements DiscountRate{
        private String customerName;
        private String customerType;

        public Customer(String customerName, String customerType) {
            this.customerName = customerName;
            this.customerType = customerType;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerType() {
            return customerType;
        }

        public void setCustomerType(String customerType) {
            this.customerType = customerType;
        }


        public double getServiceMemberDiscount() {
            switch (customerType) {
                case "Premium":
                    return 0.20;
                case "Gold":
                    return 0.15;
                case "Silver":
                    return 0.10;
                case "Normal":
                    return 0.0;
                default:
                    return 0;
            }
        }


        public double getProductMemberDiscount() {
            switch (customerType) {
                case "Premium":
                case "Gold":
                case "Silver":
                    return 0.10;
                default:
                    return 0;
            }
        }
    }


    class Sale {

       private Customer customer;
        private String date;
        private double serviceExpense;
        private double productExpense;

        public Sale(Customer customer, String date) {
            setCustomer(customer).setDate(date);
        }

        public Sale setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Sale setDate(String date) {
            this.date = date;
            return this;
        }



        public double getServiceExpense() {
            return serviceExpense;
        }

        public void setServiceExpense(double serviceExpense) {
            this.serviceExpense = serviceExpense;
        }

        public double getProductExpense() {
            return productExpense;
        }

        public void setProductExpense(double productExpense) {
            this.productExpense = productExpense;
        }

        public double getTotalExpense() {
            return serviceExpense + productExpense;
        }

        public void displayInfo() {
            double serviceDiscount = customer.getServiceMemberDiscount() * serviceExpense;
            double productDiscount = customer.getProductMemberDiscount() * productExpense;

            double discountedServiceExpense = serviceExpense - serviceDiscount;
            double discountedProductExpense = productExpense - productDiscount;

            double totalExpense = discountedServiceExpense + discountedProductExpense;

            System.out.println("Customer: " + customer.getCustomerName());
            System.out.println("Date: " + date);
            System.out.println("Service Expense: " + serviceExpense + " (Discount: " + serviceDiscount + ")");
            System.out.println("Product Expense: " + productExpense + " (Discount: " + productDiscount + ")");
            System.out.println("Total Expense: " + totalExpense);
        }
    }


public class ShoppingClass {
        public static void main(String[] args) {

           Customer obj1 = new Customer("Vibol lalen", "Gold");
            Customer obj2 = new Customer("Rotha Votey", "Premium");

            Sale obj3 = new Sale(obj1, "2024-01-01");
            obj3.setServiceExpense(861.0);
            obj3.setProductExpense(321.0);

            Sale obj4 = new Sale(obj2, "2024-02-02");
            obj4.setServiceExpense(600.0);
            obj4.setProductExpense(49.0);

            System.out.println("Product Discount Sale:");
            obj3.displayInfo();

            System.out.println("Service Discount Sale:");
            obj4.displayInfo();


        }

        };