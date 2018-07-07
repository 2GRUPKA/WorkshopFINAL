CREATE TABLE employees(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  lastName VARCHAR(255) NOT NULL,
  address TEXT,
  phone VARCHAR(10),
  note TEXT,
  hourlyPayment INT NOT NULL
);

CREATE TABLE clients(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  lastName VARCHAR(255) NOT NULL,
  birthDate DATE NOT NULL
);

CREATE TABLE vehicles(
  id INT AUTO_INCREMENT PRIMARY KEY,
  brand VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  productionYear DATE,
  registrationNumber VARCHAR(255),
  nextRepairDate DATE,
  client_id INT NOT NULL,
  FOREIGN KEY (client_id) REFERENCES clients(id)

);

CREATE TABLE orders(
  id INT AUTO_INCREMENT PRIMARY KEY,
  acceptanceDate DATE,
  planningStartDate DATE,
  startRepair DATE,
  employee_id INT NOT NULL,
  problemDescription text,
  repairDescription text,
  status VARCHAR(255),
  vehicle_id INT NOT NULL,
  repairCost BIGINT,
  partCost BIGINT,
  repairHours INT,
  FOREIGN KEY (employee_id) REFERENCES employees(id),
  FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);