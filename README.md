# TitleNavigation
Android library for managing [Action Bar](https://developer.android.com/training/appbar/?hl=pt-br) title when navigate between fragments, it fits well in small applications.

## Download

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

implementation 'com.github.LucasFsc:TitleNavigation:0.1-beta'

```

## How do I use it?

In your MainActivity instantiate the controller class and set the inital fragment:

```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //controller
        val controller = TitleNavBaseController.Companion.Builder()
            .actionBar(supportActionBar!!)
            .defaultTitle(getString(R.string.default_title))
            .fragmentManager(supportFragmentManager).build()
        
        //set inital fragment
        controller.setInitialFragment(
            R.id.app_content,
            FragmentExample.newInstance(),
            getString(R.string.app_name)
        )

    }

    //common implementation
    override fun onBackPressed() {

        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
```
Into your fragment classes extends TitleNavBaseFragment (This step is optional):

```kotlin
class FragmentExample : TitleNavBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        
        ...
    
        //push fragments using this method, optional method
        pushFragment(R.id.app_content, FragmentExample.newInstance(), "Your awesome title here")
    }

    ...
}
```

## License
[MIT](https://github.com/LucasFsc/TitleNavigator/blob/master/LICENSE)
