package hufman;

import java.util.ArrayList;
import java.util.List;

public class mainClass {
	

	
	
	public static void switchElment( int[] arr , int firstPosition , int secondPositin ) {
		
		int temp = arr[ firstPosition ];
		arr[ firstPosition ] = arr[ secondPositin ] ;
		arr[ secondPositin ] = temp ;
		
	}
	
	
	
	public static int getRightChildPosition( int[] arr , int position ) {
		
		int i =  ( position * 2 ) + 2 ;
		
		return i ;
	}
	
	
	public static int getLeftChildPosition( int[] arr , int position ) {
		
		int i =  ( position * 2 ) + 1 ;
		
		return i ;
	}
	
	
	
	public static void createMinHeapNew( int[] arr , int size  ) {
		
		for( int i = 0 ; i < size/2 ; i++ ) {
			
			int rcp = getRightChildPosition( arr , i );
			int lcp = getLeftChildPosition(  arr , i );
			
			if( rcp < size &&  arr[ rcp ] < arr[ i ]  ) {
				switchElment( arr , rcp , i );
			}
			
			
			if( lcp < size &&  arr[ lcp ] < arr[ i ]  ) {
				switchElment( arr , lcp , i );
			}
			
		}
	}
	
	public static void createMaxHeapNew( int[] arr , int size  ) {
		
		for( int i = 0 ; i < size/2 ; i++ ) {
			
			int rcp = getRightChildPosition( arr , i );
			int lcp = getLeftChildPosition(  arr , i );
			
			if( rcp < size &&  arr[ rcp ] > arr[ i ]  ) {
				switchElment( arr , rcp , i );
			}
			
			
			if( lcp < size &&  arr[ lcp ] > arr[ i ]  ) {
				switchElment( arr , lcp , i );
			}
			
		}
	}
	
	
	

	
	public static void maxHeapify( int[] arr , int size , int index ){
		// for Max heap 
		int l = index ;
		int leftNode = 2* index + 1 ;
		int rightNode = 2* index + 2 ;
		
		if( leftNode < size && arr[l] < arr[ leftNode ] ) {
			l = leftNode ;
		}
		
		if( rightNode < size && arr[l] < arr[ rightNode ] ) {
			l = rightNode ;
		}
		
		if( l != index ) {
			
			int temp = arr[ index ] ;
			arr[ index ] = arr[ l ] ;
			arr[ l ] = temp ;
			
			maxHeapify( arr , size , l ) ;
		}
	}
	
	public static void minHeapify( int[] arr , int size , int index ){
		// for Min heap 
		int l = index ;
		int leftNode = 2* index + 1 ;
		int rightNode = 2* index + 2 ;
		
		if( leftNode < size && arr[l] > arr[ leftNode ] ) {
			l = leftNode ;
		}
		
		if( rightNode < size && arr[l] > arr[ rightNode ] ) {
			l = rightNode ;
		}
		
		if( l != index ) {
			
			int temp = arr[ index ] ;
			arr[ index ] = arr[ l ] ;
			arr[ l ] = temp ;
			
			minHeapify( arr , size , l ) ;
		}
	}
	
	
	public static void maxHeapSort( int[] arr , int size ){
		
		 createMaxHeapNew( arr , size  );
		 
		while ( size > 1 ) {
			maxHeapify(  arr ,  size , 0 );
			 switchElment( arr , 0 ,  size - 1  );
			size-- ;
		}
	}
	
	
	public static void minHeapSort( int[] arr , int size ){
		
		createMinHeapNew( arr , size  );
		 
		while ( size > 1 ) {
			minHeapify(  arr ,  size , 0 );


			  switchElment( arr , 0 ,  size - 1 );
			size-- ;
		}
	}
	
	
	

	public static void main(String[] args) {
	
		
		int[] arr = {1, 3, 7 , 5, 9, 2, 8, 4};
		 
		 int size = arr.length ;
		 
		 int[] heap = new int[ size] ;
		 
		
		
		// max heap sort
		// maxHeapSort(  arr ,  size );
		// min heap sort
		  minHeapSort(  arr ,  size );
		 
	
		 
			System.out.println(  "\n" + "Displayyn data of array " + "\n" );
			for( int i = 0 ; i < arr.length ; i++ ) {
				System.out.println( arr[ i ] );
				
			}
		 

	
		
	}

}
