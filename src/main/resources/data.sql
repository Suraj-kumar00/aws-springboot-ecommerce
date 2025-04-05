-- Insert categories first
INSERT INTO category (name, image_name, is_active) VALUES
('Electronics', 'electronics.jpg', true),
('Fashion', 'fashion.jpg', true),
('Home & Living', 'home.jpg', true),
('Books', 'books.jpg', true),
('Sports', 'sports.jpg', true),
('Beauty', 'beauty.jpg', true);

-- Insert sample products with realistic images
INSERT INTO product (title, description, category, price, stock, image, discount, discount_price, is_active) VALUES
('iPhone 15 Pro Max', 'Latest Apple iPhone with A17 Pro chip, 48MP camera system, and titanium design. Features ProMotion display and all-day battery life.', 'Electronics', 139900, 50, 'iphone15.jpg', 10, 125910, true),
('Samsung 65" QLED 4K TV', 'Premium QLED TV with Quantum Processor, Object Tracking Sound, and SpaceFit Sound. Features HDR and smart TV capabilities.', 'Electronics', 129999, 20, 'samsung-tv.jpg', 15, 110499.15, true),
('Nike Air Zoom Pegasus', 'Premium running shoes with responsive cushioning, breathable mesh upper, and durable rubber outsole. Perfect for daily training.', 'Fashion', 9995, 100, 'nike-shoes.jpg', 20, 7996, true),
('Lenovo Legion Pro 7', 'Gaming laptop with Intel Core i9, RTX 4090, 32GB RAM, 1TB SSD. Features 16" 240Hz display and advanced cooling.', 'Electronics', 299999, 15, 'gaming-laptop.jpg', 12, 263999.12, true),
('Sony WH-1000XM5', 'Premium noise-cancelling headphones with 30-hour battery life, multipoint pairing, and adaptive sound control.', 'Electronics', 34990, 75, 'headphones.jpg', 18, 28691.8, true),
('Adidas Track Suit', 'Comfortable track suit made with recycled materials. Features moisture-wicking fabric and modern fit.', 'Fashion', 4999, 200, 'tracksuit.jpg', 25, 3749.25, true),
('Apple Watch Series 9', 'Latest smartwatch with health monitoring, fitness tracking, and cellular connectivity. Features Always-On Retina display.', 'Electronics', 41900, 60, 'smartwatch.jpg', 8, 38548, true),
('DJI Mini 3 Pro', 'Lightweight drone with 4K camera, 34-minute flight time, and obstacle avoidance. Perfect for aerial photography.', 'Electronics', 89999, 25, 'drone.jpg', 15, 76499.15, true),
('Puma Running Shorts', 'Lightweight running shorts with DryCell technology and inner brief. Features reflective elements for visibility.', 'Fashion', 1999, 150, 'shorts.jpg', 30, 1399.3, true),
('Samsung Galaxy S24 Ultra', 'Flagship Android phone with Snapdragon 8 Gen 3, 200MP camera, and S Pen support. Features AI capabilities.', 'Electronics', 134999, 40, 'galaxy-s24.jpg', 10, 121499.1, true),
('Fossil Gen 6 Smartwatch', 'Wear OS smartwatch with heart rate monitoring, GPS, and fast charging. Features customizable watch faces.', 'Electronics', 24995, 45, 'fossil-watch.jpg', 22, 19496.1, true),
('Under Armour Backpack', 'Water-resistant backpack with laptop sleeve and multiple compartments. Perfect for gym or daily use.', 'Fashion', 3499, 100, 'backpack.jpg', 15, 2974.15, true),
('Bose QuietComfort Earbuds', 'True wireless earbuds with noise cancellation and touch controls. Features 6-hour battery life.', 'Electronics', 27990, 55, 'earbuds.jpg', 20, 22392, true),
('Nike Dri-FIT T-Shirt', 'Moisture-wicking training t-shirt with breathable mesh panels. Features reflective details.', 'Fashion', 2499, 250, 'tshirt.jpg', 25, 1874.25, true),
('OnePlus 12', '5G smartphone with Snapdragon 8 Gen 3, Hasselblad cameras, and 100W charging. Features 120Hz AMOLED display.', 'Electronics', 69999, 35, 'oneplus.jpg', 12, 61599.12, true); 