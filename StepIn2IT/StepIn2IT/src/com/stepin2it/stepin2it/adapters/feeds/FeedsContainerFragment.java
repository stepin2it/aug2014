package com.stepin2it.stepin2it.adapters.feeds;

import static android.widget.Toast.LENGTH_SHORT;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import com.stepin2it.stepin2it.R;
import com.stepin2it.stepin2it.customviews.stickylistheaders.StickyListHeadersListView;
import com.stepin2it.stepin2it.customviews.stickylistheaders.StickyListHeadersListView.OnHeaderClickListener;


public class FeedsContainerFragment extends Fragment implements
		AdapterView.OnItemClickListener, OnHeaderClickListener {

	private FeedsBaseAdapter mAdapter;
	private StickyListHeadersListView mStickyList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_feedscontainer, container, false);
		mStickyList = (StickyListHeadersListView) v.findViewById(R.id.list);
		mStickyList.setOnItemClickListener(this);
		mStickyList.setOnHeaderClickListener(this);

		mStickyList.addHeaderView(inflater.inflate(R.layout.feedscontainer_list_header_one, null));
		mStickyList.addFooterView(inflater.inflate(R.layout.feedscontainer_list_footer_one, null));
		mAdapter = new FeedsBaseAdapter(getActivity());
		mStickyList.setEmptyView(v.findViewById(R.id.empty));

		mStickyList.setAdapter(mAdapter);
		return v;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(getActivity(), "Item " + position + " clicked!",
				LENGTH_SHORT).show();
	}

	@SuppressLint("NewApi")
	@Override
	public void onHeaderClick(StickyListHeadersListView l, View header,
			int itemPosition, long headerId, boolean currentlySticky) {
		Toast.makeText(getActivity(), "header " + headerId, Toast.LENGTH_SHORT)
				.show();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			mStickyList.smoothScrollToPositionFromTop(
					mAdapter.getSectionStart(itemPosition)
							+ mStickyList.getHeaderViewsCount(),
					-mStickyList.getPaddingTop());
		}
	}

}
