public class solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int one = findKth(nums1, 0, nums2, 0, (n + 1)/2);
        int two = findKth(nums1, 0, nums2, 0, (n + 2)/2);
        return ((double)one + (double)two )/ 2.0;
    }
    private int findKth(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if (s1 >= nums1.length) {
            return nums2[s2 + k - 1];
        }    
        if (s2 >= nums2.length) {
            return nums1[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        int m1 = s1 + k / 2 - 1;
        int m2 = s2 + k / 2 - 1;
        int mid1 = 0;
        int mid2 = 0;
        if (m1 >= nums1.length) {
            mid1 = Integer.MAX_VALUE;
        }
        else {
            mid1 = nums1[m1];
        }
        if (m2 >= nums2.length) {
            mid2 = Integer.MAX_VALUE;
        }
        else {
            mid2 = nums2[m2];
        }
        if (mid1 < mid2) {
            return findKth(nums1, m1 + 1, nums2, s2, k - k/2);
        }
        else {
            return findKth(nums1, s1, nums2, m2 + 1, k - k/2);
        }
    }
}
