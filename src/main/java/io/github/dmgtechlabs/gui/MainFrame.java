package io.github.dmgtechlabs.gui;//GEN-LINE:variables//GEN-LINE:variables//GEN-LINE:variables//GEN-LINE:variables

import io.github.dmgtechlabs.Car;
import io.github.dmgtechlabs.Customer;
import io.github.dmgtechlabs.Employee;
import io.github.dmgtechlabs.Sale;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
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

	private class Actions {
		public static MainFrame frame;
		
		public static void addCar() {
			frame.carFrame = new CarFrame();
			GUIUtils.showFrame(frame.carFrame);
		}
		
		public static void add(JFrame frame) {
			if (frame instanceof SaleFrame sf) {
				System.out.println("SaleFrame");
				sf = new SaleFrame();
				GUIUtils.showFrame(sf);
			} else if (frame instanceof CustomerFrame cf) {
				System.out.println("CustomerFrame");
				cf = new CustomerFrame();
				GUIUtils.showFrame(cf);
			} else if (frame instanceof EmployeeFrame ef) {
				System.out.println("EmployeeFrame");
				ef = new EmployeeFrame();
				GUIUtils.showFrame(ef);
			} else if (frame instanceof CarFrame cf) {
				System.out.println("CarFrame");
				cf = new CarFrame();
				GUIUtils.showFrame(cf);
			}
		}

		public static void edit(JFrame frame, MainFrame mf) {
			if (frame instanceof SaleFrame sf) {
				System.out.println("SaleFrame");
//				if (mf.salesList.getSelectedIndex() < 0) {
//					return;
//				}
//				sf = new SaleFrame(mf.sales.get(mf.salesList.getSelectedIndex()));
//				GUIUtils.showFrame(cf);
			} else if (frame instanceof CustomerFrame cf) {
				System.out.println("CustomerFrame");
				if (mf.customerList.getSelectedIndex() < 0) {
					return;
				}
				cf = new CustomerFrame(mf.customers.get(mf.customerList.getSelectedIndex()));
				GUIUtils.showFrame(cf);
			} else if (frame instanceof EmployeeFrame ef) {
				System.out.println("EmployeeFrame");
				if (mf.employeeList.getSelectedIndex() < 0) {
					return;
				}
				ef = new EmployeeFrame(mf.employees.get(mf.employeeList.getSelectedIndex()));
				GUIUtils.showFrame(ef);
			} else if (frame instanceof CarFrame cf) {
				System.out.println("CarFrame");
				if (mf.carsList.getSelectedIndex() < 0) {
					return;
				}
				cf = new CarFrame(mf.cars.get(mf.carsList.getSelectedIndex()));
				GUIUtils.showFrame(cf);
			}
		}

		public static void delete(JFrame frame) {
			if (frame instanceof SaleFrame sf) {
				System.out.println("SaleFrame");
				sf = new SaleFrame();
				GUIUtils.showFrame(sf);
			} else if (frame instanceof CustomerFrame cf) {
				System.out.println("CustomerFrame");
				cf = new CustomerFrame();
				GUIUtils.showFrame(cf);
			} else if (frame instanceof EmployeeFrame ef) {
				System.out.println("EmployeeFrame");
				ef = new EmployeeFrame();
				GUIUtils.showFrame(ef);
			} else if (frame instanceof CarFrame cf) {
				System.out.println("CarFrame");
				cf = new CarFrame();
				GUIUtils.showFrame(cf);
			}
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

	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
		initComponents();
		GUIUtils.commonSetup(this);
		
		Actions.frame = this;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1048, 715));

		this.cardLayout = (CardLayout) this.cardContainer.getLayout();
		this.helpFrame = new HelpFrame();
		this.aboutFrame = new AboutFrame();
		this.logsFrame = null;

		this.formList.setFixedCellHeight(40);
		this.formList.setListData(new String[]{"Sales", "Cars", "Employees", "Customers"});
		this.cardLayout.addLayoutComponent(this.salesPanel, "Sales");
		this.cardLayout.addLayoutComponent(this.carsPanel, "Cars");
		this.cardLayout.addLayoutComponent(this.employeesPanel, "Employees");
		this.cardLayout.addLayoutComponent(this.customersPanel, "Customers");

		//Customers Card
		this.customerList.setFixedCellHeight(25);
		this.customers = Customer.selectAll();
		this.customerList.setListData(Customer.listToArray(customers));
		this.customersEditorPane.setContentType("text/html");
		this.customersEditorPane.setEditable(false);
		this.customersEditorPane.setFont(new Font("sans-serif", Font.PLAIN, 18));

		//Employees Card
		this.employeeList.setFixedCellHeight(25);
		this.employees = Employee.selectAll();
		this.employeeList.setListData(Employee.listToArray(employees));
		this.employeesEditorPane.setContentType("text/html");
		this.employeesEditorPane.setEditable(false);
		this.employeesEditorPane.setFont(new Font("sans-serif", Font.PLAIN, 18));

		// Sales Card
		this.salesList.setFixedCellHeight(25);
		this.sales = Sale.selectAll();
		this.salesList.setListData(Sale.listToArray(sales));
		this.salesEditorPane.setContentType("text/html");
		this.salesEditorPane.setEditable(false);
		this.salesEditorPane.setFont(new Font("sans-serif", Font.PLAIN, 18));

		// Cars Card
		this.carsList.setFixedCellHeight(25);
		this.cars = Car.selectAllCars();
		this.carsList.setListData(Car.listToArray(cars));
		this.carsEditorPane.setContentType("text/html");
		this.carsEditorPane.setEditable(false);
		this.carsEditorPane.setFont(new Font("sans-serif", Font.PLAIN, 18));
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
        addSaleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addSaleButtonMouseClicked(evt);
            }
        });
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
                        .addComponent(jScrollPane8))
                    .addGroup(salesPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                        .addComponent(addCarButton)
                        .addGap(18, 18, 18)
                        .addComponent(editCarButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteCarButton)))
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
                        .addGap(106, 106, 106)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
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
		Actions.add(this.saleFrame);
    }//GEN-LAST:event_addSaleMenuItemActionPerformed

    private void addEmployeeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeMenuItemActionPerformed
		Actions.add(this.employeeFrame);
    }//GEN-LAST:event_addEmployeeMenuItemActionPerformed

    private void addCarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCarMenuItemActionPerformed
		Actions.add(this.carFrame);
    }//GEN-LAST:event_addCarMenuItemActionPerformed

    private void addCustomerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerMenuItemActionPerformed
		Actions.add(this.customerFrame);
    }//GEN-LAST:event_addCustomerMenuItemActionPerformed

    private void addCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerButtonActionPerformed
		Actions.add(this.customerFrame);
    }//GEN-LAST:event_addCustomerButtonActionPerformed

    private void addEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeButtonActionPerformed
		Actions.add(this.employeeFrame);
    }//GEN-LAST:event_addEmployeeButtonActionPerformed

    private void addSaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSaleButtonActionPerformed
		Actions.add(this.saleFrame);
    }//GEN-LAST:event_addSaleButtonActionPerformed

    private void addCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCarButtonActionPerformed
		Actions.addCar();
    }//GEN-LAST:event_addCarButtonActionPerformed

    private void addSaleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSaleButtonMouseClicked
		Actions.add(this.saleFrame);
    }//GEN-LAST:event_addSaleButtonMouseClicked

    private void editCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCarButtonActionPerformed
		Actions.edit(this.carFrame, this);
    }//GEN-LAST:event_editCarButtonActionPerformed

    private void allRefreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRefreshMenuItemActionPerformed
		this.salesRefreshMenuItemActionPerformed(evt);
		this.carsRefreshMenuItemActionPerformed(evt);
		this.employeesRefreshMenuItemActionPerformed(evt);
		this.customersRefreshMenuItemActionPerformed(evt);
		JOptionPane.showMessageDialog(this, "Refreshed all lists");
    }//GEN-LAST:event_allRefreshMenuItemActionPerformed

    private void salesRefreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesRefreshMenuItemActionPerformed
		this.sales = Sale.selectAll();
		this.salesList.setListData(Sale.listToArray(sales));
    }//GEN-LAST:event_salesRefreshMenuItemActionPerformed

    private void carsRefreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsRefreshMenuItemActionPerformed
		this.cars = Car.selectAllCars();
		this.carsList.setListData(Car.listToArray(cars));
    }//GEN-LAST:event_carsRefreshMenuItemActionPerformed

    private void employeesRefreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesRefreshMenuItemActionPerformed
		this.employees = Employee.selectAll();
		this.employeeList.setListData(Employee.listToArray(employees));
    }//GEN-LAST:event_employeesRefreshMenuItemActionPerformed

    private void customersRefreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersRefreshMenuItemActionPerformed
		this.customers = Customer.selectAll();
		this.customerList.setListData(Customer.listToArray(customers));

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
		var car = this.cars.get(this.carsList.getSelectedIndex());
		int option = JOptionPane.showConfirmDialog(
			this,
			"Are you sure you want to delete " + car.getLicencePlate() + "?"
		);

		if (option != 0) {
			return;
		}

		car.delete();
		carsRefreshMenuItemActionPerformed(null);
		GUIUtils.showInfo(carsEditorPane, this.cars.get(0));
    }//GEN-LAST:event_deleteCarButtonActionPerformed

    private void deleteCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomerButtonActionPerformed
		var customer = this.customers.get(this.customerList.getSelectedIndex());
		int option = JOptionPane.showConfirmDialog(
			this,
			"Are you sure you want to delete " + customer.getName() + "?"
		);

		if (option != 0) {
			return;
		}

		customer.delete();
		customersRefreshMenuItemActionPerformed(null);
		GUIUtils.showInfo(customersEditorPane, customer);
    }//GEN-LAST:event_deleteCustomerButtonActionPerformed

    private void deleteEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmployeeButtonActionPerformed
		var employee = this.employees.get(this.employeeList.getSelectedIndex());
		int option = JOptionPane.showConfirmDialog(
			this,
			"Are you sure you want to delete " + employee.getName() + "?"
		);

		if (option != 0) {
			return;
		}

		employee.delete();
		employeesRefreshMenuItemActionPerformed(null);
		GUIUtils.showInfo(employeesEditorPane, employee);
    }//GEN-LAST:event_deleteEmployeeButtonActionPerformed

    private void editCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerButtonActionPerformed
		Actions.edit(this.customerFrame, this);
    }//GEN-LAST:event_editCustomerButtonActionPerformed

    private void editEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmployeeButtonActionPerformed
		Actions.edit(this.employeeFrame, this);
    }//GEN-LAST:event_editEmployeeButtonActionPerformed

    private void employeeLogsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeLogsMenuItemActionPerformed
		if (this.logsFrame != null && this.logsFrame.isShowing()) {
			return;
		}

		this.logsFrame = new LogsFrame(LogsFrame.LogType.EMPLOYEES);
		this.logsFrame.setVisible(true);
    }//GEN-LAST:event_employeeLogsMenuItemActionPerformed

    private void editSaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSaleButtonActionPerformed
        this.saleFrame = new SaleFrame(this.sales.get(this.salesList.getSelectedIndex()));
		GUIUtils.showFrame(this.saleFrame);
    }//GEN-LAST:event_editSaleButtonActionPerformed

    private void deleteSaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSaleButtonActionPerformed
		var sale = this.sales.get(this.salesList.getSelectedIndex());
		int option = JOptionPane.showConfirmDialog(
			this,
			"Are you sure you want to delete " + sale.getId() + "?"
		);

		if (option != 0) {
			return;
		}

		sale.delete();
		salesRefreshMenuItemActionPerformed(null);
		GUIUtils.showInfo(salesEditorPane, sale);
    }//GEN-LAST:event_deleteSaleButtonActionPerformed

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
    private javax.swing.JPanel cardContainer;
    private javax.swing.JEditorPane carsEditorPane;
    private javax.swing.JList<String> carsList;
    private javax.swing.JMenuItem carsLogsMenuItem;
    private javax.swing.JPanel carsPanel;
    private javax.swing.JMenuItem carsRefreshMenuItem;
    private javax.swing.JList<String> customerList;
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
    private javax.swing.JEditorPane employeesEditorPane;
    private javax.swing.JPanel employeesPanel;
    private javax.swing.JMenuItem employeesRefreshMenuItem;
    private javax.swing.JList<String> formList;
    private javax.swing.JScrollPane formListContainer;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JMenu logsMenu;
    private javax.swing.JMenu refreshMenu;
    private javax.swing.JEditorPane salesEditorPane;
    private javax.swing.JList<String> salesList;
    private javax.swing.JPanel salesPanel;
    private javax.swing.JMenuItem salesRefreshMenuItem;
    // End of variables declaration//GEN-END:variables
}
