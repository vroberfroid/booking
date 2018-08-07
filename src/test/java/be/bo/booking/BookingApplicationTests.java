package be.bo.booking;

import java.util.Date;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import be.bo.booking.api.IBookingService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingApplicationTests {

	@Test
	public void contextLoads() {
		Calendar cal = Calendar.getInstance();
		Calendar calTemp = (Calendar) cal.clone();
		calTemp.set(2018,7,19);
		Date d = calTemp.getTime();		
		Reservation r = new Reservation(d, 1, Reservation.Type.MAINTENANCE, "First maintenance");
		
		given(service.getReservation(r)).willReturn(r);
		
		service.addReservation(r);
		Reservation r2 = service.getReservation(r);
		r2.getDate();
		assertThat(r.getDate()).isEqualTo(r2.getDate());
	}
	
	@MockBean
	private IBookingService service;

}
