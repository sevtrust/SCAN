package ac;
/* 
 * Reference arithmetic coding
 * Copyright (c) Project Nayuki
 * 
 * https://www.nayuki.io/page/reference-arithmetic-coding
 * https://github.com/nayuki/Reference-arithmetic-coding
 */

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;


/**
 * A stream of bits that can be read. Because they come from an underlying byte stream,
 * the total number of bits is always a multiple of 8. The bits are read in big endian.
 * Mutable and not thread-safe.
 * @see BitOutputStream
 */
public final class BitInputStream implements AutoCloseable {
	
	/*---- Fields ----*/
	
	// The underlying byte stream to read from (not null).
	private InputStream input;
	
	// Either in the range [0x00, 0xFF] if bits are available, or -1 if end of stream is reached.
	private int currentbyte;
	
	// Number of remaining bits in the current byte, always between 0 and 7 (inclusive).
	private int numBitsRemaining;
	private byte[] inputbyte;
	private int i;
	
	
	
	/*---- Constructor ----*/
	
	/**
	 * Constructs a bit input stream based on the specified byte input stream.
	 * @param in the byte input stream
	 * @throws NullPointerException if the input stream is {@code null}
	 */
	public BitInputStream(InputStream in) {
		if (in == null)
			throw new NullPointerException();
		input = in;
		currentbyte = 0;
		numBitsRemaining = 0;
	}
	
	public BitInputStream(byte[] in){
		inputbyte = in;
		currentbyte = 0;
		numBitsRemaining = 0;
		i =0;
	}
	
	
	
	/*---- Methods ----*/
	
	/**
	 * Reads a bit from this stream. Returns 0 or 1 if a bit is available, or -1 if
	 * the end of stream is reached. The end of stream always occurs on a byte boundary.
	 * @return the next bit of 0 or 1, or -1 for the end of stream
	 * @throws IOException if an I/O exception occurred
	 */
	public int read() throws IOException {
		if (currentbyte == -1)
				return -1;
		if (numBitsRemaining == 0) {
			if(input !=null)
				currentbyte = input.read();
			else{
				if(i == inputbyte.length) 
					currentbyte = -1;
				else{
					currentbyte =inputbyte[i];
					i++;
				}
			}
			if (currentbyte == -1)
				return -1;
			numBitsRemaining = 8;
		}
		if (numBitsRemaining <= 0)
			throw new AssertionError();
		numBitsRemaining--;
		return (currentbyte >>> numBitsRemaining) & 1;
	}
	
	
	/**
	 * Reads a bit from this stream. Returns 0 or 1 if a bit is available, or throws an {@code EOFException}
	 * if the end of stream is reached. The end of stream always occurs on a byte boundary.
	 * @return the next bit of 0 or 1
	 * @throws IOException if an I/O exception occurred
	 * @throws EOFException if the end of stream is reached
	 */
	public int readNoEof() throws IOException {
		int result = read();
		if (result != -1)
			return result;
		else
			throw new EOFException();
	}
	
	
	/**
	 * Closes this stream and the underlying input stream.
	 * @throws IOException if an I/O exception occurred
	 */
	public void close() throws IOException {
		if(input != null)
			input.close();
		currentbyte = -1;
		numBitsRemaining = 0;
	}
	
	public InputStream getInputStream(){
		return input;
	}

	public int getNumBitsRemaining(){
		return numBitsRemaining;
	}

	public void read(byte[] bytes) throws IOException {
		input.read(bytes);
	}
	
	
}
