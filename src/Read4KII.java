
public class Read4KII {
	/**
	 * The API: int read4(char *buf) reads 4 characters at a time from a file.
	 * The return value is the actual number of characters read. For example, it returns 3 
	 * if there is only 3 characters left in the file. By using the read4 API, implement the function 
	 * int read(char *buf, int n) that reads n characters from the file.
	 */
	/* 
	 * The read function may be called multiple times.
	 * The previous one we can't use it for multiple times since read4 actually read more and break continuity.
	 * This one will sovle that problem. read the buffer used last time.(through offset)
	 */
	public int read4(char[] buf){
		return 4;
	}
	/**
	* @param buf Destination buffer
	* @param n   Maximum number of characters to read
	* @return    The number of characters read
	*/
	public int read(char[] buf, int n){
		char[] buffer = new char[4];
		boolean eof = true;
		int total = 0;
		while(eof && total <= n){
			int temp = read4(buffer);
			if(temp < 4)
				eof = false;
			int bytes = Math.min(n-total, temp);
			System.arraycopy(buffer, 0, buf, total, bytes);
			total += bytes;
		}
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
