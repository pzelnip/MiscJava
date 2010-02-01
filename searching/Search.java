/*
	Search.java - Comparing some various searching algorithms

	Author: Adam Parkin
	Date: November 11, 2009
*/

import java.util.*;

public class Search
{
	// use a global counter to keep track of how many times a
	// search algorithm iterates (or recurses) 
	static int iterCount;

	public static void main (String [] args)
	{
		int [] nums = {11, 18, 29, 37, 42, 49, 51, 63, 69, 72, 77, 82, 88, 91, 98};
		testSearch (nums, 72);	// number in the middle somewhere
		testSearch (nums, 11);	// number at the beginning
		testSearch (nums, 98);	// number at the end
		testSearch (nums, 52);	// number not in array

		// just to prove how much of a difference the various methods are,
		// lets try it with a VERY LARGE array of numbers (8,888,888 of them)
		int [] bigArray = genLargeSortedRandomArray (8888888);

		testSearch (bigArray, bigArray[bigArray.length / 2]);		// number in the middle 
		testSearch (bigArray, bigArray[0]);				// number at the beginning
		testSearch (bigArray, bigArray[bigArray.length - 1]);		// number at the end 
		testSearch (bigArray, bigArray[bigArray.length - 1] + 1);	// number not in the array 
	}

	/*
	test the various search algorithms on the supplied array of ints, trying to
	find the target int
	*/
	public static void testSearch (int [] nums, int target)
	{
		System.out.println ("--------------------------------");
		System.out.println ("Testing search methods for the value " + target +
			" in an array of " + nums.length + " elements");

		iterCount = 0;
		System.out.println ("Sequential Search for " + target + " gave result: " + 
			sequentialSearchIterative (nums, target) + " in " + iterCount +
			" iterations");

		iterCount = 0;
		System.out.println ("iterative binary Search for " + target + " gave result: " + 
			binSearchIterative (nums, target)+ " in " + iterCount +
			" iterations");

		iterCount = 0;
		System.out.println ("recursive binary Search for " + target + " gave result: " + 
			binSearchRecursive (nums, target, 0, nums.length - 1) + " in " + iterCount +
			" iterations");
		System.out.println ("--------------------------------");
	}

	/*
	Binary Search using iteration (looping)
	*/
	public static int binSearchIterative (int [] arr, int target)
	{
		int min = 0;
		int max = arr.length - 1;

		while (min <= max)
		{
			iterCount++;	// update iteration count
			int mid = (min + max) / 2;
			if (arr[mid] == target)
				return mid;
			else if (arr[mid] < target)
				min = mid + 1;
			else
				max = mid - 1;
		}
		return -1;
	}

	/*
	Binary Search using recursion
	*/
	public static int binSearchRecursive (int [] arr, int target, int min, int max)
	{
		iterCount++;	// update iteration count

		if (min > max)
			return -1;
		else
		{
			int mid = (min + max) / 2;
			if (arr[mid] == target)
				return mid;
			else if (arr[mid] < target)
				return binSearchRecursive (arr, target, mid + 1, max);
			else
				return binSearchRecursive (arr, target, min, mid - 1);
		}
	}

	/*
	Basic sequential search
	*/
	public static int sequentialSearchIterative (int [] arr, int target)
	{
		for (int x = 0; x < arr.length; x++)
		{
			iterCount++;	// update iteration count

			if (arr[x] == target)
				return x;
		}
		return -1;
	}

	/*
	Generate an array of numElements integers in sorted order. The elements themselves
	are randomly generated
	*/
	public static int [] genLargeSortedRandomArray (int numElements)
	{
		int [] ret = new int[numElements];
		Random r = new Random();

		// fill array with random numbers
		for (int x = 0; x < ret.length; x++)
			ret[x] = r.nextInt(99999999);

		// sort it
		Arrays.sort (ret);

		return ret;
	}
}
