package in.fssa.agzone.model;

public class Product {


		private int id;
		private String grainname;
		private String varietyname;
		private  Float quantity;
		private Price price;


		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getGrainName() {
			return grainname;
		}

		public void setGrainName(String grainname) {
			this.grainname = grainname;
		}

		public String getVarietyName() {
			return varietyname;
		}

		public void setVarietyName(String varietyname) {
			this.varietyname = varietyname;
		}

		public Float getQuantity() {
			return quantity;
		}

		public void setQuantity(Float quantity) {
			this.quantity = quantity;
		}
		public Price getPrice() {
			return price;
		}

		public void setPrice(Price price) {
			this.price = price;
		}

	

		@Override
		public String toString() {
			return "ProductEntity [id=" + id + ", grainname=" + grainname + ", varietyname=" + varietyname + ", quantity=" +quantity + ", price=" + price + "]";
		}
		
	}

//public class Product {
//    private String grainName;
//    private String varietyName;
//    private int quantity;
//    private double price;
//
//    public Product(String grainName, String varietyName, int quantity, double price) {
//        this.grainName = grainName;
//        this.varietyName = varietyName;
//        this.quantity = quantity;
//        this.price = price;
//    }
//
//    public Product() {
//    	
//    }
//    public String getGrainName() {
//        return grainName;
//    }
//
//    public void setGrainName(String grainName) {
//        this.grainName = grainName;
//    }
//
//    public String getVarietyName() {
//        return varietyName;
//    }
//
//    public void setVarietyName(String varietyName) {
//        this.varietyName = varietyName;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Float quantity) {
//        this.quantity = quantity;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "grainName='" + grainName + '\'' +
//                ", varietyName='" + varietyName + '\'' +
//                ", quantity=" + quantity +
//                ", price=" + price +
//                '}';
//    }
//}



