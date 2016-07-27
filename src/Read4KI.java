
public class Read4KI {
	/**
	 * The API: int read4(char *buf) reads 4 characters at a time from a file.
	 * The return value is the actual number of characters read. For example, it returns 3 if there is only 
	 * 3 characters left in the file. By using the read4 API, implement the function int read(char *buf, int n) 
	 * that reads n characters from the file.
	 * Note: The read function will only be called once for each test case.
	 */
	char[] buffer = new char[4];
	int bufsize = 0;
	int offset = 0;
	public int read4(char[] buf){
		return 4;
	}
	/**
	* @param buf Destination buffer
	* @param n   Maximum number of characters to read
	* @return    The number of characters read
	*/
	public int read(char[] buf, int n){
		boolean eof = true;
		int total = 0;
		while(eof && total < n){
			if(bufsize == 0){
				bufsize = read4(buffer);
				if(bufsize < 4)
					eof = false;
			}
			int bytes = Math.min(n-total, bufsize);
			System.arraycopy(buffer, offset, buf, total, bytes);
			bufsize -= bytes; 
			offset = (offset+bytes)%4;
			total += bytes;
		}
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
