package io.github.dmgtechlabs.gui;//GEN-LINE:variables//GEN-LINE:variables//GEN-LINE:variables//GEN-LINE:variables

import io.github.dmgtechlabs.Car;
import io.github.dmgtechlabs.Customer;
import io.github.dmgtechlabs.Email;
import io.github.dmgtechlabs.Employee;
import io.github.dmgtechlabs.Manufacturer;
import io.github.dmgtechlabs.Model;
import io.github.dmgtechlabs.Sale;
import io.github.dmgtechlabs.UIObject;
import io.github.dmgtechlabs.Utils;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import kdesp73.databridge.helpers.SQLogger;

public class MainFrame extends javax.swing.JFrame {

	private HelpFrame helpFrame;
	private AboutFrame aboutFrame;
	private LogsFrame logsFrame;
	private CardLayout cardLayout;
	private SaleFrame saleFrame;
	private EmployeeFrame employeeFrame;
	private CustomerFrame customerFrame;
	private CarFrame carFrame;
	private ServiceFrame serviceFrame;

	private class Actions {

		public static MainFrame frame;

		public static void addCar() {
			frame.carFrame = new CarFrame();
			GUIUtils.addWindowClosedListener(frame.carFrame, refreshCarsRunnable());
			GUIUtils.showFrame(frame.carFrame);
		}

		public static void addCustomer() {
			frame.customerFrame = new CustomerFrame();
			GUIUtils.addWindowClosedListener(frame.customerFrame, refreshCustomersRunnable());
			GUIUtils.showFrame(frame.customerFrame);
		}

		public static void addEmployee() {
			frame.employeeFrame = new EmployeeFrame();
			GUIUtils.addWindowClosedListener(frame.employeeFrame, refreshEmployeesRunnable());
			GUIUtils.showFrame(frame.employeeFrame);
		}

		public static void addSale() {
			frame.saleFrame = new SaleFrame();
			GUIUtils.addWindowClosedListener(frame.saleFrame, refreshSalesRunnable());
			GUIUtils.showFrame(frame.saleFrame);
		}

		public static void editCar() {
			if (frame.carsList.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(frame, "Please select an item first", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			frame.carFrame = new CarFrame(frame.cars.get(frame.carsList.getSelectedIndex()));
			GUIUtils.addWindowClosedListener(frame.carFrame, refreshCarsRunnable());
			GUIUtils.showFrame(frame.carFrame);
		}

		public static void editCustomer() {
			if (frame.customerList.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(frame, "Please select an item first", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			frame.customerFrame = new CustomerFrame(frame.customers.get(frame.customerList.getSelectedIndex()));
			GUIUtils.addWindowClosedListener(frame.customerFrame, refreshCustomersRunnable());
			GUIUtils.showFrame(frame.customerFrame);
		}

		public static void editEmployee() {
			if (frame.employeeList.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(frame, "Please select an item first", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			frame.employeeFrame = new EmployeeFrame(frame.employees.get(frame.employeeList.getSelectedIndex()));
			GUIUtils.addWindowClosedListener(frame.employeeFrame, refreshEmployeesRunnable());
			GUIUtils.showFrame(frame.employeeFrame);
		}

		public static void editSale() {
			if (frame.salesList.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(frame, "Please select an item first", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (frame.salesList.getSelectedIndex() < 0) {
				return;
			}
			frame.saleFrame = new SaleFrame(frame.sales.get(frame.salesList.getSelectedIndex()));
			GUIUtils.addWindowClosedListener(frame.saleFrame, refreshSalesRunnable());
			GUIUtils.showFrame(frame.saleFrame);
		}

		public static void deleteCar() {
			if (frame.carsList.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(frame, "Please select an item first", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			var car = frame.cars.get(frame.carsList.getSelectedIndex());
			int option = JOptionPane.showConfirmDialog(
				frame,
				"Are you sure you want to delete " + car.getLicencePlate() + "?"
			);

			if (option != 0) {
				return;
			}

			car.delete();
			refreshCars();
			GUIUtils.showInfo(frame.carsEditorPane, frame.cars.get(0));
		}

		public static void deleteCustomer() {
			if (frame.customerList.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(frame, "Please select an item first", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			var customer = frame.customers.get(frame.customerList.getSelectedIndex());
			int option = JOptionPane.showConfirmDialog(
				frame,
				"Are you sure you want to delete " + customer.getName() + "?"
			);

			if (option != 0) {
				return;
			}

			customer.delete();
			refreshCustomers();
			GUIUtils.showInfo(frame.customersEditorPane, customer);
		}

		public static void deleteEmployee() {
			if (frame.employeeList.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(frame, "Please select an item first", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			var employee = frame.employees.get(frame.employeeList.getSelectedIndex());
			int option = JOptionPane.showConfirmDialog(
				frame,
				"Are you sure you want to delete " + employee.getName() + "?"
			);

			if (option != 0) {
				return;
			}

			employee.delete();
			refreshEmployees();
			GUIUtils.showInfo(frame.employeesEditorPane, employee);
		}

		public static void deleteSale() {
			if (frame.salesList.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(frame, "Please select an item first", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			var sale = frame.sales.get(frame.salesList.getSelectedIndex());
			int option = JOptionPane.showConfirmDialog(
				frame,
				"Are you sure you want to delete " + sale.getId() + "?"
			);

			if (option != 0) {
				return;
			}

			sale.delete();
			refreshSales();
			GUIUtils.showInfo(frame.salesEditorPane, sale);
		}

		public static void updateService() {
			if (frame.carsList.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(frame, "Please select an item first", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			frame.serviceFrame = new ServiceFrame(frame.cars.get(frame.carsList.getSelectedIndex()).getService());
			GUIUtils.addWindowClosedListener(frame.serviceFrame, refreshCarsRunnable());
			GUIUtils.showFrame(frame.serviceFrame);
		}

		private static Runnable asRunnable(Runnable method) {
			return method;
		}

		public static Runnable refreshCarsRunnable() {
			return asRunnable(() -> {
				refreshCars();
			});
		}

		public static Runnable refreshCustomersRunnable() {
			return asRunnable(() -> {
				refreshCustomers();
			});
		}

		public static Runnable refreshEmployeesRunnable() {
			return asRunnable(() -> {
				refreshEmployees();
			});
		}

		public static Runnable refreshSalesRunnable() {
			return asRunnable(() -> {
				refreshSales();
			});
		}

		public static Runnable refreshAllRunnable() {
			return asRunnable(() -> {
				refreshAll();
			});
		}

		public static void refreshCars() {
			frame.cars = Car.selectAllCars();
			frame.carsList.setListData(UIObject.listToArray(frame.cars.stream().map(car -> (UIObject) car).toList()));
			frame.carsEditorPane.setText(Utils.HTML.paragraph(""));
		}

		public static void refreshCustomers() {
			frame.customers = Customer.selectAll();
			frame.customerList.setListData(UIObject.listToArray(frame.customers.stream().map(customer -> (UIObject) customer).toList()));
			frame.customersEditorPane.setText(Utils.HTML.paragraph(""));
		}

		public static void refreshEmployees() {
			frame.employees = Employee.selectAll();
			frame.employeeList.setListData(UIObject.listToArray(frame.employees.stream().map(employee -> (UIObject) employee).toList()));
			frame.employeesEditorPane.setText(Utils.HTML.paragraph(""));
		}

		public static void refreshSales() {
			frame.sales = Sale.selectAll();
			frame.salesList.setListData(UIObject.listToArray(frame.sales.stream().map(sale -> (UIObject) sale).toList()));
			frame.salesEditorPane.setText(Utils.HTML.paragraph(""));
		}

		public static void refreshAll() {
			refreshCars();
			refreshCustomers();
			refreshEmployees();
			refreshSales();
			JOptionPane.showMessageDialog(frame, "Refreshed all lists");
		}
	}

	// Customers Card
	private List<Customer> customers;

	// Employees Card
	private List<Employee> employees;

	// Sales Card
	private List<Sale> sales;

	// Cars Card
	private List<Car> cars;

	// Search Card
	private List<Model> models;
	private List<Manufacturer> manufacturers;

	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
		initComponents();
		GUIUtils.commonSetup(this);
		this.setTitle("car-manager");
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1048, 715));

		this.cardLayout = (CardLayout) this.cardContainer.getLayout();
		this.helpFrame = new HelpFrame();
		this.aboutFrame = new AboutFrame();
		this.logsFrame = null;

		this.formList.setFixedCellHeight(40);
		this.formList.setListData(new String[]{"Sales", "Cars", "Employees", "Customers", "Search"});
		this.cardLayout.addLayoutComponent(this.salesPanel, "Sales");
		this.cardLayout.addLayoutComponent(this.carsPanel, "Cars");
		this.cardLayout.addLayoutComponent(this.employeesPanel, "Employees");
		this.cardLayout.addLayoutComponent(this.customersPanel, "Customers");
		this.cardLayout.addLayoutComponent(this.searchPanel, "Search");

		//Customers Card
		this.customerList.setFixedCellHeight(25);
		this.customers = Customer.selectAll();
		this.customerList.setListData(UIObject.listToArray(this.customers.stream().map(customer -> (UIObject) customer).toList()));
		this.customersEditorPane.setContentType("text/html");
		this.customersEditorPane.setEditable(false);
		this.customersEditorPane.setFont(new Font("sans-serif", Font.PLAIN, 18));

		//Employees Card
		this.employeeList.setFixedCellHeight(25);
		this.employees = Employee.selectAll();
		this.employeeList.setListData(UIObject.listToArray(this.employees.stream().map(employee -> (UIObject) employee).toList()));
		this.employeesEditorPane.setContentType("text/html");
		this.employeesEditorPane.setEditable(false);
		this.employeesEditorPane.setFont(new Font("sans-serif", Font.PLAIN, 18));

		// Sales Card
		this.salesList.setFixedCellHeight(25);
		this.sales = Sale.selectAll();
		this.salesList.setListData(UIObject.listToArray(this.sales.stream().map(sale -> (UIObject) sale).toList()));
		this.salesEditorPane.setContentType("text/html");
		this.salesEditorPane.setEditable(false);
		this.salesEditorPane.setFont(new Font("sans-serif", Font.PLAIN, 18));

		// Cars Card
		this.carsList.setFixedCellHeight(25);
		this.cars = Car.selectAllCars();
		this.carsList.setListData(UIObject.listToArray(this.cars.stream().map(car -> (UIObject) car).toList()));
		this.carsEditorPane.setContentType("text/html");
		this.carsEditorPane.setEditable(false);
		this.carsEditorPane.setFont(new Font("sans-serif", Font.PLAIN, 18));

		// Search Card
		this.manufacturers = Manufacturer.selectAllManufacturers();
		for (Manufacturer m : this.manufacturers) {
			this.manufacturersComboBox1.addItem(m.UIString());
		}
		for (Manufacturer m : this.manufacturers) {
			this.manufacturersComboBox2.addItem(m.UIString());
		}
		for (Customer c : this.customers) {
			this.customerComboBox.addItem(c.UIString());
		}
		for (Employee e : this.employees) {
			this.employeesComboBox.addItem(e.UIString());
		}

		GUIUtils.setPlaceholder(this.employeesByEmailTextField, "Email");
		GUIUtils.setPlaceholder(this.customersByEmailTextField, "Email");
		this.carPriceTextFormattedField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				String text = carPriceTextFormattedField.getText();

				// Allow only digits and a single dot that is not the first character
				if (!(Character.isDigit(c) || (c == '.' && !text.isEmpty() && !text.contains(".")))) {
					e.consume();
				}
			}
		});

		Actions.frame = this;
		GUIUtils.addKeyBinding(this.rootPane, "F5", Actions.refreshAllRunnable());
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formListContainer = new javax.swing.JScrollPane();
        formList = new javax.swing.JList<>();
        cardContainer = new javax.swing.JPanel();
        salesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        addSaleButton = new javax.swing.JButton();
        editSaleButton = new javax.swing.JButton();
        deleteSaleButton = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        salesEditorPane = new javax.swing.JEditorPane();
        carsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        carsList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        addCarButton = new javax.swing.JButton();
        editCarButton = new javax.swing.JButton();
        deleteCarButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        carsEditorPane = new javax.swing.JEditorPane();
        serviceCarButton = new javax.swing.JButton();
        employeesPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        employeeList = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        addEmployeeButton = new javax.swing.JButton();
        editEmployeeButton = new javax.swing.JButton();
        deleteEmployeeButton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        employeesEditorPane = new javax.swing.JEditorPane();
        customersPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        customerList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        addCustomerButton = new javax.swing.JButton();
        editCustomerButton = new javax.swing.JButton();
        deleteCustomerButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        customersEditorPane = new javax.swing.JEditorPane();
        searchPanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        searchResultsTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        manufacturersComboBox1 = new javax.swing.JComboBox<>();
        carsByModelButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        manufacturersComboBox2 = new javax.swing.JComboBox<>();
        carsByManufacturerButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        customerComboBox = new javax.swing.JComboBox<>();
        salesByCustomer = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        employeesComboBox = new javax.swing.JComboBox<>();
        salesByEmployeeButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        customersByEmailButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        employeesByEmailButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        carsByPriceButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        carsByServiceComboBox = new javax.swing.JComboBox<>();
        carsByServiceButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        combobox = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        carsBySoldButton = new javax.swing.JButton();
        customersByEmailTextField = new javax.swing.JFormattedTextField();
        employeesByEmailTextField = new javax.swing.JFormattedTextField();
        soldComboBox = new javax.swing.JComboBox<>();
        modelsComboBox = new javax.swing.JComboBox<>();
        resultCountLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        carPriceTextFormattedField = new javax.swing.JFormattedTextField();
        carPriceComparisonComboBox = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        addMenu = new javax.swing.JMenu();
        addSaleMenuItem = new javax.swing.JMenuItem();
        addCarMenuItem = new javax.swing.JMenuItem();
        addCustomerMenuItem = new javax.swing.JMenuItem();
        addEmployeeMenuItem = new javax.swing.JMenuItem();
        refreshMenu = new javax.swing.JMenu();
        allRefreshMenuItem = new javax.swing.JMenuItem();
        salesRefreshMenuItem = new javax.swing.JMenuItem();
        carsRefreshMenuItem = new javax.swing.JMenuItem();
        employeesRefreshMenuItem = new javax.swing.JMenuItem();
        customersRefreshMenuItem = new javax.swing.JMenuItem();
        logsMenu = new javax.swing.JMenu();
        carsLogsMenuItem = new javax.swing.JMenuItem();
        employeeLogsMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        formList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        formList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        formList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        formList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formListMouseClicked(evt);
            }
        });
        formListContainer.setViewportView(formList);

        cardContainer.setLayout(new java.awt.CardLayout());

        salesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(salesList);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SALES");

        addSaleButton.setText("ADD");
        addSaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSaleButtonActionPerformed(evt);
            }
        });

        editSaleButton.setText("EDIT");
        editSaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSaleButtonActionPerformed(evt);
            }
        });

        deleteSaleButton.setText("DELETE");
        deleteSaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSaleButtonActionPerformed(evt);
            }
        });

        jScrollPane8.setViewportView(salesEditorPane);

        javax.swing.GroupLayout salesPanelLayout = new javax.swing.GroupLayout(salesPanel);
        salesPanel.setLayout(salesPanelLayout);
        salesPanelLayout.setHorizontalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salesPanelLayout.createSequentialGroup()
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
                    .addGroup(salesPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                        .addComponent(addSaleButton)
                        .addGap(18, 18, 18)
                        .addComponent(editSaleButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteSaleButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        salesPanelLayout.setVerticalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                    .addGroup(salesPanelLayout.createSequentialGroup()
                        .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(addSaleButton)
                            .addComponent(editSaleButton)
                            .addComponent(deleteSaleButton))
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)))
                .addContainerGap())
        );

        cardContainer.add(salesPanel, "card2");

        carsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        carsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carsListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(carsList);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CARS");

        addCarButton.setText("ADD");
        addCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCarButtonActionPerformed(evt);
            }
        });

        editCarButton.setText("EDIT");
        editCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCarButtonActionPerformed(evt);
            }
        });

        deleteCarButton.setText("DELETE");
        deleteCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCarButtonActionPerformed(evt);
            }
        });

        carsEditorPane.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jScrollPane3.setViewportView(carsEditorPane);

        serviceCarButton.setText("Service");
        serviceCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceCarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout carsPanelLayout = new javax.swing.GroupLayout(carsPanel);
        carsPanel.setLayout(carsPanelLayout);
        carsPanelLayout.setHorizontalGroup(
            carsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carsPanelLayout.createSequentialGroup()
                .addGroup(carsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(carsPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                        .addComponent(addCarButton)
                        .addGap(18, 18, 18)
                        .addComponent(editCarButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteCarButton))
                    .addGroup(carsPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(serviceCarButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        carsPanelLayout.setVerticalGroup(
            carsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carsPanelLayout.createSequentialGroup()
                        .addGroup(carsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(addCarButton)
                            .addComponent(editCarButton)
                            .addComponent(deleteCarButton))
                        .addGap(75, 75, 75)
                        .addComponent(serviceCarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        cardContainer.add(carsPanel, "card3");

        employeeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        employeeList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeListMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(employeeList);

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EMPLOYEES");

        addEmployeeButton.setText("ADD");
        addEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeButtonActionPerformed(evt);
            }
        });

        editEmployeeButton.setText("EDIT");
        editEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmployeeButtonActionPerformed(evt);
            }
        });

        deleteEmployeeButton.setText("DELETE");
        deleteEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmployeeButtonActionPerformed(evt);
            }
        });

        jScrollPane7.setViewportView(employeesEditorPane);

        javax.swing.GroupLayout employeesPanelLayout = new javax.swing.GroupLayout(employeesPanel);
        employeesPanel.setLayout(employeesPanelLayout);
        employeesPanelLayout.setHorizontalGroup(
            employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeesPanelLayout.createSequentialGroup()
                .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7))
                    .addGroup(employeesPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(addEmployeeButton)
                        .addGap(18, 18, 18)
                        .addComponent(editEmployeeButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteEmployeeButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        employeesPanelLayout.setVerticalGroup(
            employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeesPanelLayout.createSequentialGroup()
                        .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(addEmployeeButton)
                            .addComponent(editEmployeeButton)
                            .addComponent(deleteEmployeeButton))
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );

        cardContainer.add(employeesPanel, "card3");

        customerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        customerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(customerList);

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CUSTOMERS");

        addCustomerButton.setText("ADD");
        addCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerButtonActionPerformed(evt);
            }
        });

        editCustomerButton.setText("EDIT");
        editCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerButtonActionPerformed(evt);
            }
        });

        deleteCustomerButton.setText("DELETE");
        deleteCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomerButtonActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(customersEditorPane);

        javax.swing.GroupLayout customersPanelLayout = new javax.swing.GroupLayout(customersPanel);
        customersPanel.setLayout(customersPanelLayout);
        customersPanelLayout.setHorizontalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customersPanelLayout.createSequentialGroup()
                .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customersPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5))
                    .addGroup(customersPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addComponent(addCustomerButton)
                        .addGap(18, 18, 18)
                        .addComponent(editCustomerButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteCustomerButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        customersPanelLayout.setVerticalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customersPanelLayout.createSequentialGroup()
                        .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(addCustomerButton)
                            .addComponent(editCustomerButton)
                            .addComponent(deleteCustomerButton))
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        cardContainer.add(customersPanel, "card3");

        searchResultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(searchResultsTable);

        jLabel3.setText("Search Cars By Model");

        manufacturersComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacturersComboBox1ActionPerformed(evt);
            }
        });

        carsByModelButton.setText("Run");
        carsByModelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carsByModelButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Search Cars By Manufacturer");

        carsByManufacturerButton.setText("Run");
        carsByManufacturerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carsByManufacturerButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Search Sales By Customer");

        salesByCustomer.setText("Run");
        salesByCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesByCustomerActionPerformed(evt);
            }
        });

        jLabel8.setText("Search Sales By Employee");

        salesByEmployeeButton.setText("Run");
        salesByEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesByEmployeeButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Search Customers By Email");

        customersByEmailButton.setText("Run");
        customersByEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersByEmailButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Search Employees By Email");

        employeesByEmailButton.setText("Run");
        employeesByEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesByEmailButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("Search Cars By Price");

        carsByPriceButton.setText("Run");
        carsByPriceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carsByPriceButtonActionPerformed(evt);
            }
        });

        jLabel12.setText("Search Cars By Service                      ");

        carsByServiceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completed", "Not Completed" }));

        carsByServiceButton.setText("Run");
        carsByServiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carsByServiceButtonActionPerformed(evt);
            }
        });

        jLabel13.setText("Search Model By Manufacturer");

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton9.setText("Run");

        jLabel14.setText("Search Cars By Sold");

        carsBySoldButton.setText("Run");
        carsBySoldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carsBySoldButtonActionPerformed(evt);
            }
        });

        soldComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sold", "Not Sold" }));

        jLabel15.setText("Result Count:");

        carPriceComparisonComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ">=", "<=", "==" }));

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(searchPanelLayout.createSequentialGroup()
                                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(soldComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(136, 136, 136)
                                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(salesByCustomer, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(carsBySoldButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchPanelLayout.createSequentialGroup()
                                        .addComponent(manufacturersComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(136, 136, 136)
                                        .addComponent(carsByManufacturerButton))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchPanelLayout.createSequentialGroup()
                                        .addComponent(manufacturersComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(modelsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(136, 136, 136)
                                        .addComponent(carsByModelButton))))
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(searchPanelLayout.createSequentialGroup()
                                            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(employeesByEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(carPriceTextFormattedField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(136, 136, 136)
                                            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(employeesByEmailButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(carsByPriceButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(searchPanelLayout.createSequentialGroup()
                                            .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(136, 136, 136)
                                            .addComponent(jButton9))
                                        .addGroup(searchPanelLayout.createSequentialGroup()
                                            .addComponent(carsByServiceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(136, 136, 136)
                                            .addComponent(carsByServiceButton)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(employeesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(customersByEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(136, 136, 136)
                                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(customersByEmailButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(salesByEmployeeButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(carPriceComparisonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addGap(19, 19, 19)
                        .addComponent(resultCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addComponent(jScrollPane9)
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(manufacturersComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carsByModelButton)
                    .addComponent(modelsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(manufacturersComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carsByManufacturerButton))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(carsBySoldButton)
                    .addComponent(soldComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salesByCustomer))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(employeesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salesByEmployeeButton))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(customersByEmailButton)
                    .addComponent(customersByEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(employeesByEmailButton)
                    .addComponent(employeesByEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(carsByPriceButton)
                    .addComponent(carPriceTextFormattedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carPriceComparisonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(carsByServiceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carsByServiceButton))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resultCountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cardContainer.add(searchPanel, "card6");

        addMenu.setText("Add");

        addSaleMenuItem.setText("Sale");
        addSaleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSaleMenuItemActionPerformed(evt);
            }
        });
        addMenu.add(addSaleMenuItem);

        addCarMenuItem.setText("Car");
        addCarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCarMenuItemActionPerformed(evt);
            }
        });
        addMenu.add(addCarMenuItem);

        addCustomerMenuItem.setText("Customer");
        addCustomerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerMenuItemActionPerformed(evt);
            }
        });
        addMenu.add(addCustomerMenuItem);

        addEmployeeMenuItem.setText("Employee");
        addEmployeeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeMenuItemActionPerformed(evt);
            }
        });
        addMenu.add(addEmployeeMenuItem);

        jMenuBar1.add(addMenu);

        refreshMenu.setText("Refresh");

        allRefreshMenuItem.setText("All");
        allRefreshMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allRefreshMenuItemActionPerformed(evt);
            }
        });
        refreshMenu.add(allRefreshMenuItem);

        salesRefreshMenuItem.setText("Sales");
        salesRefreshMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesRefreshMenuItemActionPerformed(evt);
            }
        });
        refreshMenu.add(salesRefreshMenuItem);

        carsRefreshMenuItem.setText("Cars");
        carsRefreshMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carsRefreshMenuItemActionPerformed(evt);
            }
        });
        refreshMenu.add(carsRefreshMenuItem);

        employeesRefreshMenuItem.setText("Employees");
        employeesRefreshMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesRefreshMenuItemActionPerformed(evt);
            }
        });
        refreshMenu.add(employeesRefreshMenuItem);

        customersRefreshMenuItem.setText("Customers");
        customersRefreshMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersRefreshMenuItemActionPerformed(evt);
            }
        });
        refreshMenu.add(customersRefreshMenuItem);

        jMenuBar1.add(refreshMenu);

        logsMenu.setText("Logs");

        carsLogsMenuItem.setText("Cars");
        carsLogsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carsLogsMenuItemActionPerformed(evt);
            }
        });
        logsMenu.add(carsLogsMenuItem);

        employeeLogsMenuItem.setText("Employee");
        employeeLogsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeLogsMenuItemActionPerformed(evt);
            }
        });
        logsMenu.add(employeeLogsMenuItem);

        jMenuBar1.add(logsMenu);

        helpMenu.setText("Help");

        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(helpMenuItem);

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(formListContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cardContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formListContainer)
            .addComponent(cardContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
		GUIUtils.showFrame(this.helpFrame);
	}//GEN-LAST:event_helpMenuItemActionPerformed

	private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
		GUIUtils.showFrame(this.aboutFrame);
	}//GEN-LAST:event_aboutMenuItemActionPerformed

    private void formListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formListMouseClicked
		if (evt.getButton() == MouseEvent.BUTTON1) {
			String selected = this.formList.getSelectedValue();

			this.cardLayout.show(this.cardContainer, selected);
		}
    }//GEN-LAST:event_formListMouseClicked

    private void carsLogsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsLogsMenuItemActionPerformed
		if (this.logsFrame != null && this.logsFrame.isShowing()) {
			return;
		}

		this.logsFrame = new LogsFrame(LogsFrame.LogType.CARS);
		this.logsFrame.setVisible(true);
    }//GEN-LAST:event_carsLogsMenuItemActionPerformed

    private void addSaleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSaleMenuItemActionPerformed
		Actions.addSale();
    }//GEN-LAST:event_addSaleMenuItemActionPerformed

    private void addEmployeeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeMenuItemActionPerformed
		Actions.addEmployee();
    }//GEN-LAST:event_addEmployeeMenuItemActionPerformed

    private void addCarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCarMenuItemActionPerformed
		Actions.addCar();
    }//GEN-LAST:event_addCarMenuItemActionPerformed

    private void addCustomerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerMenuItemActionPerformed
		Actions.addCustomer();
    }//GEN-LAST:event_addCustomerMenuItemActionPerformed

    private void addCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerButtonActionPerformed
		Actions.addCustomer();
    }//GEN-LAST:event_addCustomerButtonActionPerformed

    private void addEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeButtonActionPerformed
		Actions.addEmployee();
    }//GEN-LAST:event_addEmployeeButtonActionPerformed

    private void addSaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSaleButtonActionPerformed
		Actions.addSale();
    }//GEN-LAST:event_addSaleButtonActionPerformed

    private void addCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCarButtonActionPerformed
		Actions.addCar();
    }//GEN-LAST:event_addCarButtonActionPerformed

    private void editCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCarButtonActionPerformed
		Actions.editCar();
    }//GEN-LAST:event_editCarButtonActionPerformed

    private void allRefreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRefreshMenuItemActionPerformed
		Actions.refreshAll();
    }//GEN-LAST:event_allRefreshMenuItemActionPerformed

    private void salesRefreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesRefreshMenuItemActionPerformed
		Actions.refreshSales();
    }//GEN-LAST:event_salesRefreshMenuItemActionPerformed

    private void carsRefreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsRefreshMenuItemActionPerformed
		Actions.refreshCars();
    }//GEN-LAST:event_carsRefreshMenuItemActionPerformed

    private void employeesRefreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesRefreshMenuItemActionPerformed
		Actions.refreshEmployees();
    }//GEN-LAST:event_employeesRefreshMenuItemActionPerformed

    private void customersRefreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersRefreshMenuItemActionPerformed
		Actions.refreshCustomers();

    }//GEN-LAST:event_customersRefreshMenuItemActionPerformed

    private void carsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carsListMouseClicked
		if (evt.getButton() != MouseEvent.BUTTON1) {
			return;
		}

		int index = this.carsList.getSelectedIndex();
		if (index < 0) {
			return;
		}

		var obj = this.cars.get(index);
		GUIUtils.showInfo(this.carsEditorPane, obj);
    }//GEN-LAST:event_carsListMouseClicked

    private void salesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesListMouseClicked
		if (evt.getButton() != MouseEvent.BUTTON1) {
			return;
		}

		int index = this.salesList.getSelectedIndex();
		if (index < 0) {
			return;
		}

		var obj = this.sales.get(index);
		GUIUtils.showInfo(this.salesEditorPane, obj);
    }//GEN-LAST:event_salesListMouseClicked

    private void employeeListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeListMouseClicked
		if (evt.getButton() != MouseEvent.BUTTON1) {
			return;
		}

		int index = this.employeeList.getSelectedIndex();
		if (index < 0) {
			return;
		}

		var obj = this.employees.get(index);
		GUIUtils.showInfo(this.employeesEditorPane, obj);
    }//GEN-LAST:event_employeeListMouseClicked

    private void customerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerListMouseClicked
		if (evt.getButton() != MouseEvent.BUTTON1) {
			return;
		}

		int index = this.customerList.getSelectedIndex();
		if (index < 0) {
			return;
		}

		var obj = this.customers.get(index);
		GUIUtils.showInfo(this.customersEditorPane, obj);
    }//GEN-LAST:event_customerListMouseClicked

    private void deleteCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCarButtonActionPerformed
		Actions.deleteCar();
    }//GEN-LAST:event_deleteCarButtonActionPerformed

    private void deleteCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomerButtonActionPerformed
		Actions.deleteCustomer();
    }//GEN-LAST:event_deleteCustomerButtonActionPerformed

    private void deleteEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmployeeButtonActionPerformed
		Actions.deleteEmployee();
    }//GEN-LAST:event_deleteEmployeeButtonActionPerformed

    private void editCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerButtonActionPerformed
		Actions.editCustomer();
    }//GEN-LAST:event_editCustomerButtonActionPerformed

    private void editEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmployeeButtonActionPerformed
		Actions.editEmployee();
    }//GEN-LAST:event_editEmployeeButtonActionPerformed

    private void employeeLogsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeLogsMenuItemActionPerformed
		if (this.logsFrame != null && this.logsFrame.isShowing()) {
			return;
		}

		this.logsFrame = new LogsFrame(LogsFrame.LogType.EMPLOYEES);
		this.logsFrame.setVisible(true);
    }//GEN-LAST:event_employeeLogsMenuItemActionPerformed

    private void editSaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSaleButtonActionPerformed
		Actions.editSale();
    }//GEN-LAST:event_editSaleButtonActionPerformed

    private void deleteSaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSaleButtonActionPerformed
		Actions.deleteSale();
    }//GEN-LAST:event_deleteSaleButtonActionPerformed

    private void manufacturersComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacturersComboBox1ActionPerformed
		this.models = Model.selectByManufacturer(this.manufacturers.get(this.manufacturersComboBox1.getSelectedIndex()).getManufacturerName());

		this.modelsComboBox.removeAllItems();
		for (Model m : this.models) {
			this.modelsComboBox.addItem(m.UIString());
		}
    }//GEN-LAST:event_manufacturersComboBox1ActionPerformed

    private void serviceCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceCarButtonActionPerformed
		Actions.updateService();
    }//GEN-LAST:event_serviceCarButtonActionPerformed

    private void customersByEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersByEmailButtonActionPerformed
		if (this.customersByEmailTextField.getText().isEmpty()) {
			return;
		}

		String email = this.customersByEmailTextField.getText();
		if (!new Email(email).validate()) {
			JOptionPane.showMessageDialog(this, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		var result = Customer.selectByEmail(email);

		this.resultCountLabel.setText(Integer.toString(result.size()));

		var tableModel = GUIUtils.makeTableModel(UIObject.tableData(result.stream().map(obj -> (UIObject) obj).toList()), new String[]{"Name", "Birth Year", "Gender", "Email"}, false);
		this.searchResultsTable.setModel(tableModel);
    }//GEN-LAST:event_customersByEmailButtonActionPerformed

    private void carsByPriceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsByPriceButtonActionPerformed
		if (this.carPriceTextFormattedField.getText().isEmpty()) {
			return;
		}

		float price = Float.parseFloat(this.carPriceTextFormattedField.getText());
		var result = switch (this.carPriceComparisonComboBox.getSelectedIndex()) {
			case 0 ->
				Car.selectCarsByPriceGreater(price);
			case 1 ->
				Car.selectCarsByPriceLess(price);
			case 2 ->
				Car.selectCarsByPrice(price);
			default ->
				null;
		};

		this.resultCountLabel.setText(Integer.toString(result.size()));

		var tableModel = GUIUtils.makeTableModel(UIObject.tableData(result.stream().map(obj -> (UIObject) obj).toList()), new String[]{"License Plate", "Price", "Model", "Type", "WD", "Hp"}, false);
		this.searchResultsTable.setModel(tableModel);
    }//GEN-LAST:event_carsByPriceButtonActionPerformed

    private void employeesByEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesByEmailButtonActionPerformed
		if (this.employeesByEmailTextField.getText().isEmpty()) {
			return;
		}

		String email = this.employeesByEmailTextField.getText();
		if (!new Email(email).validate()) {
			JOptionPane.showMessageDialog(this, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		var result = Employee.selectByEmail(email);

		this.resultCountLabel.setText(Integer.toString(result.size()));

		var tableModel = GUIUtils.makeTableModel(UIObject.tableData(result.stream().map(obj -> (UIObject) obj).toList()), new String[]{"Salary", "Name", "Birth Year", "Gender", "Email"}, false);
		this.searchResultsTable.setModel(tableModel);
    }//GEN-LAST:event_employeesByEmailButtonActionPerformed

    private void carsByServiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsByServiceButtonActionPerformed
		var result = switch (this.carsByServiceComboBox.getSelectedIndex()) {
			case 0 ->
				Car.selectCarsByServiceCompleted(true);
			case 1 ->
				Car.selectCarsByServiceCompleted(false);
			default ->
				null;
		};

		this.resultCountLabel.setText(Integer.toString(result.size()));

		var tableModel = GUIUtils.makeTableModel(UIObject.tableData(result.stream().map(obj -> (UIObject) obj).toList()), new String[]{"License Plate", "Price", "Model", "Type", "WD", "Hp"}, false);
		this.searchResultsTable.setModel(tableModel);
    }//GEN-LAST:event_carsByServiceButtonActionPerformed

    private void carsByModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsByModelButtonActionPerformed
		int selectedModelId = 0;

		for (int i = 0; i < this.models.size(); i++) {
			if (this.models.get(i).UIString().equals(this.modelsComboBox.getSelectedItem().toString())) {
				selectedModelId = this.models.get(i).getId();
				break;
			}
		}

		var result = Car.selectCarByModel(selectedModelId);

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

		this.resultCountLabel.setText(Integer.toString(result.size()));

		var tableModel = GUIUtils.makeTableModel(UIObject.tableData(result.stream().map(obj -> (UIObject) obj).toList()), new String[]{"License Plate", "Price", "Model", "Type", "WD", "Hp"}, false);
		this.searchResultsTable.setModel(tableModel);

    }//GEN-LAST:event_carsByModelButtonActionPerformed

    private void carsByManufacturerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsByManufacturerButtonActionPerformed
		var result = Car.selectCarByManufacturer(this.manufacturersComboBox2.getSelectedItem().toString());

		this.resultCountLabel.setText(Integer.toString(result.size()));

		var tableModel = GUIUtils.makeTableModel(UIObject.tableData(result.stream().map(obj -> (UIObject) obj).toList()), new String[]{"License Plate", "Price", "Model", "Type", "WD", "Hp"}, false);
		this.searchResultsTable.setModel(tableModel);
    }//GEN-LAST:event_carsByManufacturerButtonActionPerformed

    private void carsBySoldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsBySoldButtonActionPerformed
		var result = switch (this.soldComboBox.getSelectedIndex()) {
			case 0 ->
				Car.selectCarsBySold(true);
			case 1 ->
				Car.selectCarsBySold(false);
			default ->
				null;
		};

		this.resultCountLabel.setText(Integer.toString(result.size()));

		var tableModel = GUIUtils.makeTableModel(UIObject.tableData(result.stream().map(obj -> (UIObject) obj).toList()), new String[]{"License Plate", "Price", "Model", "Type", "WD", "Hp"}, false);
		this.searchResultsTable.setModel(tableModel);
    }//GEN-LAST:event_carsBySoldButtonActionPerformed

    private void salesByCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesByCustomerActionPerformed
		int selectedCustomerId = 0;

		for (int i = 0; i < this.customers.size(); i++) {
			if (this.customers.get(i).UIString().equals(this.customerComboBox.getSelectedItem().toString())) {
				selectedCustomerId = this.customers.get(i).getId();
				break;
			}
		}

		var result = Sale.selectSaleByCustomer(selectedCustomerId);

		this.resultCountLabel.setText(Integer.toString(result.size()));

		var tableModel = GUIUtils.makeTableModel(UIObject.tableData(result.stream().map(obj -> (UIObject) obj).toList()), new String[]{"Price", "Discount", "Customer", "Employee", "Licence Plate"}, false);
		this.searchResultsTable.setModel(tableModel);
    }//GEN-LAST:event_salesByCustomerActionPerformed

    private void salesByEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesByEmployeeButtonActionPerformed
		int selectedEmployeeId = 0;

		for (int i = 0; i < this.employees.size(); i++) {
			if (this.employees.get(i).UIString().equals(this.employeesComboBox.getSelectedItem().toString())) {
				System.out.println("Here");
				selectedEmployeeId = this.employees.get(i).getEmployeeId();
				break;
			}
		}

		var result = Sale.selectSaleByEmployee(selectedEmployeeId);

		this.resultCountLabel.setText(Integer.toString(result.size()));

		var tableModel = GUIUtils.makeTableModel(UIObject.tableData(result.stream().map(obj -> (UIObject) obj).toList()), new String[]{"Price", "Discount", "Customer", "Employee", "Licence Plate"}, false);
		this.searchResultsTable.setModel(tableModel);
    }//GEN-LAST:event_salesByEmployeeButtonActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton addCarButton;
    private javax.swing.JMenuItem addCarMenuItem;
    private javax.swing.JButton addCustomerButton;
    private javax.swing.JMenuItem addCustomerMenuItem;
    private javax.swing.JButton addEmployeeButton;
    private javax.swing.JMenuItem addEmployeeMenuItem;
    private javax.swing.JMenu addMenu;
    private javax.swing.JButton addSaleButton;
    private javax.swing.JMenuItem addSaleMenuItem;
    private javax.swing.JMenuItem allRefreshMenuItem;
    private javax.swing.JComboBox<String> carPriceComparisonComboBox;
    private javax.swing.JFormattedTextField carPriceTextFormattedField;
    private javax.swing.JPanel cardContainer;
    private javax.swing.JButton carsByManufacturerButton;
    private javax.swing.JButton carsByModelButton;
    private javax.swing.JButton carsByPriceButton;
    private javax.swing.JButton carsByServiceButton;
    private javax.swing.JComboBox<String> carsByServiceComboBox;
    private javax.swing.JButton carsBySoldButton;
    private javax.swing.JEditorPane carsEditorPane;
    private javax.swing.JList<String> carsList;
    private javax.swing.JMenuItem carsLogsMenuItem;
    private javax.swing.JPanel carsPanel;
    private javax.swing.JMenuItem carsRefreshMenuItem;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JComboBox<String> customerComboBox;
    private javax.swing.JList<String> customerList;
    private javax.swing.JButton customersByEmailButton;
    private javax.swing.JFormattedTextField customersByEmailTextField;
    private javax.swing.JEditorPane customersEditorPane;
    private javax.swing.JPanel customersPanel;
    private javax.swing.JMenuItem customersRefreshMenuItem;
    private javax.swing.JButton deleteCarButton;
    private javax.swing.JButton deleteCustomerButton;
    private javax.swing.JButton deleteEmployeeButton;
    private javax.swing.JButton deleteSaleButton;
    private javax.swing.JButton editCarButton;
    private javax.swing.JButton editCustomerButton;
    private javax.swing.JButton editEmployeeButton;
    private javax.swing.JButton editSaleButton;
    private javax.swing.JList<String> employeeList;
    private javax.swing.JMenuItem employeeLogsMenuItem;
    private javax.swing.JButton employeesByEmailButton;
    private javax.swing.JFormattedTextField employeesByEmailTextField;
    private javax.swing.JComboBox<String> employeesComboBox;
    private javax.swing.JEditorPane employeesEditorPane;
    private javax.swing.JPanel employeesPanel;
    private javax.swing.JMenuItem employeesRefreshMenuItem;
    private javax.swing.JList<String> formList;
    private javax.swing.JScrollPane formListContainer;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JMenu logsMenu;
    private javax.swing.JComboBox<String> manufacturersComboBox1;
    private javax.swing.JComboBox<String> manufacturersComboBox2;
    private javax.swing.JComboBox<String> modelsComboBox;
    private javax.swing.JMenu refreshMenu;
    private javax.swing.JLabel resultCountLabel;
    private javax.swing.JButton salesByCustomer;
    private javax.swing.JButton salesByEmployeeButton;
    private javax.swing.JEditorPane salesEditorPane;
    private javax.swing.JList<String> salesList;
    private javax.swing.JPanel salesPanel;
    private javax.swing.JMenuItem salesRefreshMenuItem;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTable searchResultsTable;
    private javax.swing.JButton serviceCarButton;
    private javax.swing.JComboBox<String> soldComboBox;
    // End of variables declaration//GEN-END:variables
}
