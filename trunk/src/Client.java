
public class Client {

	Service service;
	public Client(Service service) {
		this.service = service;
	}
	
	public static void main(String[] args) {
		Service s = new ServiceImp();
		Client c = new Client(s);
		c.requestService(); 
	}

	private void requestService() {
		service.sayHello();
	}
}
