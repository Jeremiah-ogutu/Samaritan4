package com.moringaschool.g_samaritan.Util;

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void  onItemDismiss(int position);
}
