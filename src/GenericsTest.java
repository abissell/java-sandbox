final class GenericsTest {
	interface GenericMessage<T> {

	}

	interface ParentMessageListener<T> {
		<T> void handleMessage(Class<T> type, GenericMessage<T> instance);
	}

	// "marker interface"
	interface StringMessageListener<T extends String> extends ParentMessageListener<T> {

	}

	//
	interface  IntMessageListener<T extends Integer> extends ParentMessageListener<T> {

	}

	interface StringMessage<T extends String> extends GenericMessage<T> {
		String getString();
	}

	interface IntMessage<T extends Integer> extends GenericMessage<T> {
		int getInt();
	}

	class IntMessageImpl<T extends Integer> implements IntMessage<T> {
		IntMessageImpl() {

		}

		public int getInt() {
			return 0;
		}
	}

	class StringListenerImpl<T extends String> implements StringMessageListener<T> {

		public <T> void handleMessage(Class<T> type, GenericMessage<T> genericMessage) {
			StringMessage stringMessage = (StringMessage) genericMessage; // Typesafe cast since T extends String
			String message = stringMessage.getString();
			// Do something with message
		}
	}

	class IntListenerImpl<T extends Integer> implements IntMessageListener<T> {

		public <T> void handleMessage(Class<T> type, GenericMessage<T> genericMessage) {
			IntMessage intMessage = (IntMessage) genericMessage; // Typesafe cast since T extends String
			int message = intMessage.getInt();
			// Do something with message
		}
	}

	void showTypeChecking() {
		GenericMessage<String> badStringMessage = new IntMessageImpl<>();

		ParentMessageListener<Integer> badIntListener = new StringListenerImpl<>();

		ParentMessageListener<String> stringListener1 = new StringListenerImpl<>();
		ParentMessageListener<String> stringListener2 = new StringListenerImpl<>();
		ParentMessageListener<Integer> intListener = new IntListenerImpl<>();

		GenericMessage<String> stringMessage = new GenericMessage<String>() {};

		stringListener1.handleMessage(String.class, stringMessage);
		stringListener1.handleMessage(Integer.class, stringMessage);

		GenericMessage<Integer> intMessage = new GenericMessage<Integer>() {};
		intListener.handleMessage(Integer.class, intMessage);

		GenericMessage<String> badIntMessage = new GenericMessage<String>() {};
		intListener.handleMessage(Integer.class, badIntMessage);

		GenericMessage uncheckedMessage = new IntMessageImpl();
		intListener.handleMessage(Integer.class, uncheckedMessage);

		ParentMessageListener uncheckedListener = new StringListenerImpl();
		uncheckedListener.handleMessage(String.class, stringMessage);
	}
}
