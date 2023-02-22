///1- Add the required dependencies to your project's build file, such as spring-jdbc, mysql-connector-java, and spring-webmvc



/// 2-Create a data access object (DAO) that uses Spring's JDBC template to execute SQL queries and map the results to Java objects.( should be in the History page )
@Repository
public class OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    private static final class OrderRowMapper implements RowMapper<Order> {
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setOrderId(rs.getInt("order_id"));
            order.setCustomerId(rs.getInt("customer_id"));
            order.setProductId(rs.getInt("product_id"));
            order.setQuantity(rs.getInt("quantity"));
            order.setTotal(rs.getDouble("total"));
            return order;
        }
    }
}


///3-  inject the DAO into your service layer or controller and use it to retrieve the order history data.( following code should be in the controller)
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }
}

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/orders")
    public ModelAndView showOrderHistory() {
        List<Order> orders = orderService.getAllOrders();
        return new ModelAndView("orderHistory", "orders", orders);
    }
}
