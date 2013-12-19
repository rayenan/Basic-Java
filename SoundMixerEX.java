public class SoundMixerEX {

	public static void main(String[] args) {
		double[] array = {0.12, -0.12, 0.10, 0.23, -0.47, 0.39, -0.40, 0.18, 0.25, 0.00, 0.09, 0.07, -0.56, 0.15, -0.78, 0.15, 0.12, -0.54, -0.13, 0.38};
		double[] array2 = {-0.09, -0.08, -0.17, -0.26, -0.25, -0.14, -0.83, -0.02, -0.01, 0.06, 0.15, 0.29, 0.73, 0.04, 0.65, 0.76, 0.07, 0.18, 0.19, 0.01};

		printArray(array);
		
		System.out.println();
		
		adjustVolume(array, 2, 15, 0.5);
		//print array after adjusting the volume
		printArray(array);
		
		System.out.println();
		
		add(array, array2);
		
		//print array after adding the two arrays together
		printArray(array);
		
		System.out.println();
		
		//print array2 before reverse method
		printArray(array2);
		
		System.out.println();
		
		reverse(array2);
		
		//print array2 after reversing the order
		printArray(array2);
		
		System.out.println();
		
		splice(array, 0, 5, array2, 0);
		
		//print array2 after splicing has occured
		printArray(array2);
		
		System.out.println();
		
		array2 = adjustFrequency(array2, 2);
		
		//print array2 after frequency adjusted
		printArray(array2);
	}

	//prints out values of the array passed in through parameters from main
	public static void printArray(double[] myArray) {
		for (int i=0; i < myArray.length; i++) {
			System.out.print(myArray[i] + " ");

		}
		System.out.println();
	}

	//method to change the values in the array "samples" from start index to end index by factor amount
	public static void adjustVolume(double [] samples, double startIndex, double endIndex, double factor) {

		//check to make sure parameters are not outside of startIndex values; returns to main if so
		if(startIndex < 0 || startIndex >= samples.length) {
			System.out.println("Invalid startIndex");
			return;

		}
		//check to make sure parameters are not outside of endIndex values; returns to main if so
		if(endIndex < 0 || endIndex > samples.length) {
			System.out.println("Invalid endIndex");
			return;

		}
		//if parameters pass checks, continue with for loop
		for(int i= (int)startIndex; i < endIndex; i++) {
			samples[i] = samples[i] * factor;
		}

	}
	//method to add the two arrays together and to adjust the values if they are larger than 1
	public static void add(double [] samples1, double [] samples2) {
		double val = 0.1;
		for(int i = 0; i < samples1.length; i++) {
			samples1[i] = samples1[i] + samples2[i];

			if(samples1[i] > 1) { // adjust volume if adding gives result >1
				adjustVolume(samples1, i, i+1, val);

			}
		}

	}
	//method to reverse the order of an array
	public static void reverse(double[] samples) {

		for(int i=0; i<samples.length/2; i++) {
			double temp = samples[i];
			samples[i] = samples[samples.length - i - 1];
			samples[samples.length - i - 1] = temp;
		}

	}

	//splice in a segment of array1 into array2 according to the given parameters
	public static void splice(double [] source, int sourceStart, int sourceStop, double [] destination, int destStart) {

		for(int i=sourceStart; i<=sourceStop; i++) {
			destination [destStart + i] = source [sourceStart + i];
			//return to main if sourceStop is greater than the length of souce and/or if the array destination is does not have enough space
			if(sourceStop>source.length || destination.length<sourceStop) {
				return;
			}

		}

	}

	public static double[] adjustFrequency(double[] samples, double factor) {
		//if factor > 1, frequency is decreased; if factor < 1 (but >0), frequency is increased
		int newSamplesIndex = 0;
		double[] newSamples = new double [samples.length/(int)factor];
		double samplesIndex = 0.0;

		for(int i=0; i<=newSamples.length-1; i++) {
			newSamples[newSamplesIndex + i] = samples[(int)samplesIndex];
			samplesIndex = samplesIndex + (int)factor;

		}
	return newSamples;
	}

}