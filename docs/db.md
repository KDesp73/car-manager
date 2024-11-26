# db

## Saved Queries

- [x] Car
- [x] Customer
- [x] Employee
- [x] Manufacturer
- [x] Model
- [x] Person
- [x] Sale
- [x] Service

## Requirements

- [x] 5 tables
- [x] Postgresql
- [x] Log file
- [x] Dynamic queries (forms)

## Paper

- [x] ER
- [ ] 2000 words

## Used saved procedures/functions

### Car

- insert_car(varchar, float4, int4)
- update_car(int4, varchar, float4, int4)
- delete_car(varchar)
- select_all_cars__()
- select_cars_by_model(varchar)
- select_cars_by_manufacturer(varchar)
- select_cars_by_sold(bool)
- select_cars_by_price_greater(float4)
- select_cars_by_price_less(float4)
- select_cars_by_price(float4)
- select_cars_by_service_completed()
- select_cars_by_service_not_completed()

### Model

- insert_model(varchar, int4, int4, int4, int4, int4)
- update_model(int4, varchar, int4, int4, int4, int4, int4)
- delete_model(int4)
- populate_model()
- select_all_models()
- select_models_by_manufacturer(varchar)

### Manufacturer

- insert_manufacturer(varchar, varchar)
- update_manufacturer(int4, varchar, varchar)
- delete_manufacturer(varchar)
- populate_manufacturer()
- select_all_manufacturers()
- select_manufacturers_by_location(varchar)

### Service

- update_service(int4, bool, bool, bool, bool, bool)

### Employee

- insert_employee(float, varchar, varchar, int4, int4, varchar)
- update_employee(int4, float, varchar, varchar, int4, int4, varchar)
- delete_employee(int4)
- select_all_employees__()
- select_employees_by_email(varchar)

### Customer

- insert_customer(varchar, varchar, int4, int4, varchar)
- update_customer(int4, varchar, varchar, int4, int4, varchar)
- delete_customer(int4)
- select_all_customers__()
- select_customers_by_email(varchar)

### Sales

- insert_sale(float4, float4, int4, int4, int4)
- update_sale(int4, float4, float4, int4, int4, int4)
- delete_sale(int4)
- select_all_sales__()
- select_sales_by_customer(int4)
- select_sales_by_employee(int4)
- select_sale_by_id(int4)
- select_sales_by_month(int4)

### Car Log

- create_car_log()
- select_all_car_logs()

### Employee Log

- create_employee_log()
- select_all_employee_logs()
