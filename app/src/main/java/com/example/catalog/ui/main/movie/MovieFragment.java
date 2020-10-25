package com.example.catalog.ui.main.movie;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.catalog.R;
import com.example.catalog.adapter.MovieAdapter;
import com.example.catalog.model.Movie;
//import com.example.catalog.ui.main.detail.DetailFragmentDirections;
import com.example.catalog.ui.splash.SplashFragmentDirections;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieFragment extends Fragment {


    @BindView(R.id.rv_movie)
    RecyclerView rv_movie;

//    @BindView(R.id.btnToMovie)
//    Button button;

    private  MovieViewModel viewModel;
    private MovieAdapter adapter;

    public MovieFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        adapter = new MovieAdapter(getContext());

        rv_movie.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_movie.setAdapter(adapter);

        viewModel = ViewModelProviders.of(getActivity()).get(MovieViewModel.class);
        viewModel.getMovieCollection().observe(requireActivity(), observeViewModel);

    }



    private Observer<List<Movie>> observeViewModel = movies -> {
        if (movies != null){
           adapter.setListMovie(movies);
           adapter.notifyDataSetChanged();
//                adapter.setMovies(movies);
//                adapter.notifySetDataChanged();
//                recylerView
        }
    };

}