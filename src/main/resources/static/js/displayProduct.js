// gpu = row0
// cpu = row1

const gpu = new Product();
const cpu = new Product();

// >> name, description, image, price, sold, quantity
/* 
id: 
name: varchar(45)
description: varchar(200)
imageUrl: varchar(200)
price: double
sold: int
quantity: int
*/

gpu.addProduct(
  "Asus GTX 3090",
  "This is an Asus GTX 3090",
  "./imgs/products/asusGTX3090.jpg",
  1399,
  "300 sold, 5/5",
  "5 available"
);

gpu.addProduct(
  "EVGA GTX 3090",
  "This is an EVGA GTX 3090",
  "./imgs/products/evgaGTX3090.jpg",
  1499,
  "310 sold, 5/5",
  "6 available"
);
gpu.addProduct(
  "Gigabyte GTX 3090",
  "This is an Gigabyte GTX 3090",
  "./imgs/products/gigabyteGTX3090.jpg",
  1599,
  "320 sold, 5/5",
  "7 available"
);
gpu.addProduct(
  "MSI GTX 3090",
  "This is an MSI GTX 3090",
  "./imgs/products/asusGTX3090.jpg",
  1699,
  "330 sold, 5/5",
  "8 available"
);

// display gpu
gpu.displayProduct(0, "gpu");

cpu.addProduct(
  "AMD 3200G 0",
  "This is an AMD 3200G 0",
  "./imgs/products/amd3200G.jpg",
  200,
  "100 sold, 5/5",
  "1 available"
);
cpu.addProduct(
  "AMD 3200G 1",
  "This is an AMD 3200G 1",
  "./imgs/products/amd3200G.jpg",
  200,
  "100 sold, 5/5",
  "1 available"
);
cpu.addProduct(
  "AMD 3200G 2",
  "This is an AMD 3200G 2",
  "./imgs/products/amd3200G.jpg",
  200,
  "100 sold, 5/5",
  "1 available"
);
cpu.addProduct(
  "AMD 3200G 3",
  "This is an AMD 3200G 3",
  "./imgs/products/amd3200G.jpg",
  200,
  "100 sold, 5/5",
  "1 available"
);

// display cpu
cpu.displayProduct(1, "cpu");
