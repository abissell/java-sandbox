import org.junit.Test;

public class TestBitwise {
	public TestBitwise() {

	}

	@Test
	public void testMaskOperations() {
		final long length = 16L;
		final long mask = length - 1L;

		for (long i = 0; i < 32; i++) {
			System.out.println(i & mask);
		}
	}
}
