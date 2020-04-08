package com.afro.Hashtable;


// https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem

public class IceCreamParlor {

	  // Complete the whatFlavors function below.
	static void whatFlavors(int[] cost, int money) {
		  int first_index=0;
		        int second_index=0;
		        for (int i=0;i<cost.length-1;i++)
		   {
		       first_index=i;
		        for (int j=i+1;j<cost.length;j++)
		        {
		            second_index=j;
		            if(cost[first_index]+cost[second_index]==money)
		            {
		                first_index++;second_index++;
		                System.out.println(first_index+" "+second_index);
		               return;
		            }
		        }

		    }
		    }

    }