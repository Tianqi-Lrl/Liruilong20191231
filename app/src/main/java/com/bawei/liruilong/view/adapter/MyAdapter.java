package com.bawei.liruilong.view.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.liruilong.R;
import com.bawei.liruilong.model.bean.Bean;
import com.bawei.liruilong.util.NetUtil;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Time:2019/12/31
 * Author:天祈Aa
 * Description:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Bean.RankingBean> ranking;
    //找控件
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.tv2)
    TextView tv2;


    public MyAdapter(List<Bean.RankingBean> ranking) {
        this.ranking = ranking;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局
        View view = View.inflate(parent.getContext(), R.layout.show, null);
        //绑定
        ButterKnife.bind(parent);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Bean.RankingBean rankingBean = ranking.get(position);
        holder.tv.setText(rankingBean.getRank());
        holder.tv2.setText(rankingBean.getName());
        NetUtil.getInstance().getPhoto(rankingBean.getAvatar(),holder.iv);
    }

    @Override
    public int getItemCount() {
        return ranking.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final TextView tv2;
        private final ImageView iv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv);
            tv2 = itemView.findViewById(R.id.tv2);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
