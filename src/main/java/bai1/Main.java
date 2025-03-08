package bai1;

import bai1.model.Order;

public class Main {

	public static void main(String[] args) {
		// Tạo một đơn hàng
		Order order = new Order("DH-12345");

		// Thử các hoạt động khác nhau trong trạng thái Mới tạo
//		order.verifyOrder();  // Nên thành công và chuyển trạng thái

		// Bây giờ ở trạng thái Đang xử lý
//		order.processOrder();  // Nên thành công và chuyển trạng thái

		// Bây giờ ở trạng thái Đang vận chuyển
//		order.shipOrder();     // Nên thành công nhưng giữ nguyên trạng thái
//		order.deliverOrder();  // Nên thành công và chuyển trạng thái

		// Bây giờ ở trạng thái Đã giao
		// Thử hủy một đơn hàng đã giao
//		order.cancelOrder();   // Nên thất bại vì đơn hàng đã được giao

//		System.out.println("\n----- Tạo đơn hàng mới để minh họa việc hủy -----");

		// Tạo đơn hàng khác để minh họa việc hủy
		Order order2 = new Order("DH-67890");
		order2.verifyOrder();  // Chuyển sang trạng thái Đang xử lý
		order2.cancelOrder();  // Hủy từ trạng thái Đang xử lý

		// Thử các hoạt động trên đơn hàng đã hủy
		order2.verifyOrder();  // Nên thất bại
		order2.processOrder(); // Nên thất bại
	}

}
