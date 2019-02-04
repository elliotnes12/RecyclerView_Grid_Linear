package mx.unpoco.todo.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static mx.unpoco.todo.recycler.R.layout.view;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private List<String> data;
    private RecyclerView.LayoutManager layout;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.my_recycler_view);
        data = new ArrayList();
        data.add("Data 1");
        data.add("Data 2");
        data.add("Data 3");
        data.add("Data 4");
        data.add("Data 5");
        data.add("Data 6");
        data.add("Data 7");
        data.add("Data 8");
        data.add("Data 9");
        data.add("Data 10");
        data.add("Data 11");
        data.add("Data 12");
        data.add("Data 13");
        data.add("Data 14");
        data.add("Data 15");
        data.add("Data 16");
        data.add("Data 17");
        data.add("Data 18");


        layout = new LinearLayoutManager(this);
        layout = new GridLayoutManager(this,2);
        adapter = new MyAdapter(data, view, new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(String valor, int posicion) {

            }
        });


        recycler.setLayoutManager(layout);
        recycler.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu ) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){

            case R.id.add:
                  data.add("Nuevo elemento "+data.size());
                  adapter.notifyItemChanged(data.size());
                return true;

                default:
                    return super.onOptionsItemSelected(item);

        }

    }
}
