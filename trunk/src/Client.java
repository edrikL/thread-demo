
public class Client {

	Service service;
	public Client() {
		this.service =  new ServiceProxy();
	}
	
	public static void main(String[] args) {
		Client c = new Client();
		c.requestService(); 
	}

	private void requestService() {
		service.sayHello();
	}
}
