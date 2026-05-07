***
 Company Cloudsufi Cloud based company

***

- Technical round 1
    JDBC connection string issue how to handle the concatenation string in 
    Leet code Medium question
---

- Technical round 2
---
Desing a full Builder design Pattern

PaymentStrategy  <--- Interface
   /     |     \
UPIPayment CardPayment NetBankingPayment

PaymentService --> uses PaymentStrategy

1. Strategy Interface

public interface PaymentStrategy {
    void pay(double amount);
}

2. Concrete Strategies
public class UPIPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI");
    }
}

public class CardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Card");
    }
}

public class NetBankingPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via NetBanking");
    }
}

3. Context Class
public class PaymentService {
    private PaymentStrategy strategy;

    public PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void doPayment(double amount) {
        strategy.pay(amount);
    }
}

4. Client Code

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService(new UPIPayment());
        service.doPayment(1000);

        service = new PaymentService(new CardPayment());
        service.doPayment(5000);
    }
}

Final Output 

public class Connection {

    // Mandatory fields
    private final String host;
    private final int port;
    private final String username;
    private final String password;

    // Optional fields
    private final int timeout;
    private final boolean useSSL;
    private final String schema;
    private final int poolSize;

    // Private constructor
    private Connection(Builder builder) {
        this.host = builder.host;
        this.port = builder.port;
        this.username = builder.username;
        this.password = builder.password;
        this.timeout = builder.timeout;
        this.useSSL = builder.useSSL;
        this.schema = builder.schema;
        this.poolSize = builder.poolSize;
    }

    // -------------- BUILDER ------------------

    public static class Builder {

        // Mandatory
        private final String host;
        private final int port;
        private final String username;
        private final String password;

        // Optional
        private int timeout = 3000;
        private boolean useSSL = false;
        private String schema = "public";
        private int poolSize = 10;

        // Builder constructor — mandatory fields only
        public Builder(String host, int port, String username, String password) {
            if (host == null || host.isEmpty())
                throw new IllegalArgumentException("Host is mandatory");
            if (port <= 0)
                throw new IllegalArgumentException("Port is mandatory");
            if (username == null || username.isEmpty())
                throw new IllegalArgumentException("Username is mandatory");
            if (password == null || password.isEmpty())
                throw new IllegalArgumentException("Password is mandatory");

            this.host = host;
            this.port = port;
            this.username = username;
            this.password = password;
        }

        // Optional fields setters (return builder for fluent API)
        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder useSSL(boolean useSSL) {
            this.useSSL = useSSL;
            return this;
        }

        public Builder schema(String schema) {
            this.schema = schema;
            return this;
        }

        public Builder poolSize(int poolSize) {
            this.poolSize = poolSize;
            return this;
        }

        // Build method -> returns final immutable object
        public Connection build() {
            return new Connection(this);
        }
    }

    @Override
    public String toString() {
        return "Connection{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", timeout=" + timeout +
                ", useSSL=" + useSSL +
                ", schema='" + schema + '\'' +
                ", poolSize=" + poolSize +
                '}';
    }
}


public class Main {
    public static void main(String[] args) {

        Connection connection = new Connection.Builder(
                "localhost",
                5432,
                "admin",
                "secret"
        )
        .timeout(5000)
        .useSSL(true)
        .schema("public")
        .poolSize(20)
        .build();

        System.out.println(connection);
    }
}

Problem 1: SQL based high volume data processing in batch queries in sql

Select id, name, roll_no, createdDate from Stkudetn where id> last_process_id
order by id asc;
limit 10000;

Problem 2: 
Given an array containing n numbers. The problem is to find the length of the longest contiguous subarray such that every element in the subarray is strictly greater than its previous element in the same subarray. Time Complexity should be O(n).

Examples:  

Input : arr[] = {5, 6, 3, 5, 7, 8, 9, 1, 2}
Output : 5
The subarray is {3, 5, 7, 8, 9}

Input : arr[] = {12, 13, 1, 5, 4, 7, 8, 10, 10, 11}
Output : 4
The subarray is {4, 7, 8, 10}


public class soultion{

	public static int(int[] arr){
		
		int maxLen =1;
		int currentLen =1;
		int start =0;
		int initStart =0
		for(int i=1; i<arr.length;i++){ 5 > 5 
			if(arr[i]> arr[i-1]){
				currlent++; // 
			} 
			else{
				currentLen= 1; 
				start = i	// 4 
			}
			
			if(currentlen> maxlength){ //1 >2
				maxLen = curretlent; //2
				initStart = start; // 0
			}
		return maxlength;
	}
}
- Manager + HR 
